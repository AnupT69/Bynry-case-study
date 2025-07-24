
@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class ApiController {

    @Autowired
    private AlertService alertService;

    @GetMapping("/{companyId}/alerts/low-stock")
    public ResponseEntity<?> getLowStocksAlerts(@PathVariable Long companyId) {
        List<LowStockAlertResponse> alerts = alertService.getLowStockAlerts(companyId);

        Map<String, Object> response = new HashMap<>();
        response.put("alerts", alerts);
        response.put("total_alerts",alerts.size());

        return ResponseEntity.ok(response);
    }
    
}
