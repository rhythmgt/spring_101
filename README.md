# spring_101

Simple assignment to start with spring boot. Connected spring boot with locally hosted postgres db (db at port 5431) and spring on port 8080.

Create a downtime:

curl --location --request POST '{base-url}/create-downtime?provider=any_provider&flow_name=any_flow_name' \
--header 'Content-Type: application/json' \
--data-raw '{
    "downFrom" : "2022-07-01T11:38:27",
    "downTo" : "2022-07-01T15:38:29"
}'

Read all downtimes:

curl --location --request GET '{base-url}/get-all-downtimes'

Read a downtime:

curl --location --request GET '{base-url}/get-downtime/{id}'

Update a downtime:

curl --location --request PUT '{base-url}/update-downtime/{id}?provider=any_provider&flow_name=any_flow_name' \
--header 'Content-Type: application/json' \
--data-raw '{
    "downFrom" : "2022-07-01T11:38:27",
    "downTo" : "2022-07-01T15:38:29"
}'

Delete a downtime:

curl --location --request DELETE '{base-url}/delete-downtime/{id}' 

In local deployment base-url is localhost:8080
