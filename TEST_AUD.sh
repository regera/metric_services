set -x

echo
echo "(using Id)..."
echo
time curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/AudienceInsights/1
echo
echo "(using transactionId/key)..."
echo
time curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/AudienceInsights/search/1001/CATEGORY
time curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/AudienceInsights/search/1001/GROUPID
time curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/AudienceInsights/search/1001/SCORING_VARIABLE
time curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/AudienceInsights/search/1001/
echo
echo
