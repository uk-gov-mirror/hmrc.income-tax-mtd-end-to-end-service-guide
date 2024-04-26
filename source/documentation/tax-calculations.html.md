---
title: Tax calculations | Income Tax (Making Tax Digital) end-to-end service guide
weight: 5
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Tax calculations

As part of MTD, software providers can retrieve tax calculations directly from HMRC. HMRC calculates in-year estimates, annual forecasts and end-of-year tax calculations (final declaration). The calculation retrieved by the software is the same as the one used by HMRC. 

The customer can check their tax calculation at any time during the year. All the Self Assessment tax calculation endpoints are available in the [Individual Calculations API](/api-documentation/docs/api/service/individual-calculations-api/). There are several messages built into the API that provide guidance and explanations to customers, for example: 

- ‘Your Basic Rate limit has been increased by £8,012.11 to £375,000.00 for Pension Contribution’
- ‘One or more of your annual adjustments have not been applied because you have submitted additional income or expenses’

## Retrieving a tax calculation

When a customer wants to view a new tax calculation, the software should use the Calculation ID to retrieve it by calling the [Retrieve Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1{nino}~1self-assessment~1{taxYear}~1{calculationId}/get) endpoint. If the software does not yet have this ID, it should call the [Trigger a Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1{nino}~1self-assessment~1{taxYear}/post) endpoint to trigger it. After a successful API call, HMRC will provide a Calculation ID that can be used to retrieve the calculation output.

The retrieval can take around 5 seconds, so to avoid getting an error the software should wait at least 5 seconds before attempting to retrieve the calculation. The software then uses the ID to retrieve the calculation by calling the [Retrieve Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1{nino}~1self-assessment~1{taxYear}~1{calculationId}/get) endpoint. 

When a customer requests to view an existing calculation, the software should call the [List Self Assessment Tax Calculations](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1{nino}~1self-assessment/get) endpoint to list all the tax calculations for a given year. This endpoint lists the software-triggered calculations and HMRC-triggered calculations, including any that have failed. From the list, the customer can choose the specific calculation for which they need more details. The software then uses the Calculation ID to retrieve the complete calculation output by calling the [Retrieve Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1{nino}~1self-assessment~1{taxYear}~1{calculationId}/get) endpoint. 

If the software retrieves a calculation, it will cover only the period up to their last submission date, not the calculation retrieval date. For example, if a customer submitted their update to 1 July 2023 and they requested a calculation on 30 July 2023, they will receive a calculation only up to 1 July 2023.

### Calculations that produce errors

HMRC validates the information submitted by the software by checking the data quality and data integrity. These checks include both technical (schema) specifications and business-related factors to ensure that the data is complete and meaningful. Any validation errors will be returned by using the [Retrieve a Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1{nino}~1self-assessment~1{taxYear}~1{calculationId}/get) endpoint. The software should make sure that the validation errors are presented to the customer.

If there are validation errors, no calculation results are generated. For example, it is possible that errors in previously submitted data can prevent a calculation being performed.

To prevent the validation errors from being generated, the customer must amend their digital records. The software should resubmit the revised summary totals for the relevant periods and then call the [Trigger a Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1{nino}~1self-assessment~1{taxYear}/post) endpoint.

### Calculations that are free from errors

If there are no errors, the results of the calculation are available.

The calculation output provides a summary of each income source (for example, self-employment, UK property, foreign property, and UK bank and building society interest) and a breakdown of allowances and reliefs applied. It also includes a breakdown of the Income Tax and NIC payable. This calculation output also includes additional income submitted by the customer through their software or [HMRC online services]( /guides/income-tax-mtd-end-to-end-service-guide/documentation/tasks-outside-mtd-software.html#hmrc-online-services) and information held by HMRC.

If the customer retrieves a tax calculation during the year, it is an estimated forecast and they do not need to pay any tax at this time. They will pay tax after submitting their final declaration.

If a software provider identifies what they think could be a problem with the [Individual Calculations API](/api-documentation/docs/api/service/individual-calculations-api), they will need to contact [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk).

## HMRC Assist

<!--- Section owner: Transactional Risking --->

As part of Making Tax Digital, HMRC Assist is a set of APIs that will create a better customer experience by prompting customers with help through their software when they make the following tax calculations: 

- in-year to date
- in-year forecast
- end-of-year

HMRC Assist is a new digital service for customers who have signed up for Making Tax Digital ITSA. It will provide targeted and tailored messaging to support individual customers with their tax affairs. Agents acting on behalf of clients will receive the same service when they request a tax calculation.

The service will encourage customers to submit accurate information using personalised real-time guidance, increasing correct first-time submissions and compliance.

The service will take the calculation data of the customer, analyse the submission and generate a series of guidance materials, links and suggested actions for the customer to review. 

HMRC Assist will be integrated into the ITSA Submission Service of HMRC so that customers completing their final declaration or return amendment using [HMRC online services](/guides/income-tax-mtd-end-to-end-service-guide/documentation/tasks-outside-mtd-software.html#hmrc-online-services) will receive tailored assistance.

### Produce an HMRC Self Assessment assist report

The report contains targeted feedback based on what the customer advises HMRC in their update for the given National Insurance number (NINO), Calculation ID, and tax year.

<a href="figures/customer-journey-transactional-risking-produce-report.svg" target="blank"><img src="figures/customer-journey-transactional-risking-produce-report.svg" alt="Produce report" style="width:720px;" /></a>

<a href="figures/customer-journey-transactional-risking-produce-report.svg" target="blank">Open the produce a report diagram in a new tab.</a>

An HTTP 200 success code is returned and the targeted message, recommended action and guidance links are within the JSON for the software to display.

### Acknowledge an HMRC Self Assessment assist report

This endpoint enables you to acknowledge that the given report has been read by either the customer or agent.

<a href="figures/customer-journey-transactional-risking-acknowledge.svg" target="blank"><img src="figures/customer-journey-transactional-risking-acknowledge.svg" alt="Acknowledge a HMRC Assist Report" style="width:720px;" /></a>

<a href="figures/customer-journey-transactional-risking-acknowledge.svg" target="blank">Open the Acknowledge HMRC Assist report diagram in a new tab</a>.

To acknowledge the report, an HTTP 204 code is returned and contains no content.

### HMRC Assist customer journey

<a href="figures/customer-journey-transactional-risking-high-level.svg" target="blank"><img src="figures/customer-journey-transactional-risking-high-level.svg" alt="HMRC Assist customer journey" style="width:720px;" /></a>

<a href="figures/customer-journey-transactional-risking-high-level.svg" target="blank">Open the high-level diagram in a new tab.</a>
