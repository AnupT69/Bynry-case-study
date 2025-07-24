

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Query(
        """
    Select i from Inventor i 
    JOIN i.product p 
    Join i.warehouse w 
    WHERE w.comapany.id = :companyId
    AND i.quantity<p.threshold
    AND i.lastSaleDate >= CURRENT_DATE - 30
                
                """
    );
    List<Inventory> findLowStockAlertsByCompany(Long companyId);
}