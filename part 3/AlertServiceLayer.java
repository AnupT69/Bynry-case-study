import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertServiceLayer {
    @Autowired
    private InventoryRepository inventoryRepo;
    
    public List<LowStockAlertResponse> getLowStockAlerts(Long comapnyId) {

        //i will call here CompanyRepository to get details of comapany 
        Company com = CompanyRepo.findById(comapanyId);
        if(com == null){
            return null;
        }



        List<Inventory> lowStockInventories = inventoryRepo.findLowStockAlertsByCompany(comapnyId);

         return lowStockInventories.stream().map(inventory -> {
            var product = inventory.getProduct();
            var warehouse = inventory.getWarehouse();
            var supplier = product.getSupplier();

            // For now i am just doing fake calculations , but later we can replace it with actual one
            int avgDailySales = 2; 
            int daysUntilStockout = avgDailySales > 0 ? inventory.getQuantity() / avgDailySales : -1;

            return new LowStockAlertResponse(
                    product.getId(),
                    product.getName(),
                    product.getSku(),
                    warehouse.getId(),
                    warehouse.getName(),
                    inventory.getQuantity(),
                    product.getThreshold(),
                    daysUntilStockout,
                    new LowStockAlertResponse.SupplierInfo(
                            supplier.getId(),
                            supplier.getName(),
                            supplier.getContactEmail()
                    )
            );
        }).collect(Collectors.toList());
        
        

    }
    
}


//LowStockAlertRespose is DTO i am using