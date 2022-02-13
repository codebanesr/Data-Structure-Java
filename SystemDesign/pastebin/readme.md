### Function requirements
1. generate unique url by pasting content on pastebin
2. The content and url should expire after certain time

### Capacity estimation [10: 1 read: write]
-> 10 Million write requests per month
-> 100 Million read requests per month (10X write request)

-> Hence the total number of writing request in 10 years
= 10M*12(months/year)*10(years)= 1.2 Billion write requests

Let the maximum size per paste be 10MB.
-> Amount of paste size per month 
= 10 M*10MB = 100 TB paste/month

-> Amount of paste content in one year 
= 100TB*12 = 1200TB or 1.2PB paste/year

Assume our service runs for 10 years, 
then total data accumulated = 1200TB * 10 years = 12 PB

### SLA's
... generic