set -x
echo
echo "(using Id)..."
echo
time curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/TestData/
time curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/TestData/max/
time curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/TestData/max
read a
echo
echo "(using Since)..."
echo
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/TestData/since/1
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/TestData/since/3/1234232
echo
echo "(using text)..."
echo
time curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://valvcshad001vm/metric_services/api/TestData/search/Todd
echo
echo
