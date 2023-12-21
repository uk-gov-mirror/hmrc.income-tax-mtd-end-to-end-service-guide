---
title: Business and Property Income
weight: 4
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Business and Property Income

A customer’s MTD mandated income consists of the following:

* self-employed sole trader income
* property income

This is the ‘qualifying’ income HMRC uses to establish if the customer meets the criteria for MTD.  MTD Customers can have one, or multiple, businesses with these types of income. For more information on qualifying income, refer to [Check what is included in your qualifying income](https://www.gov.uk/guidance/check-if-youre-eligible-for-making-tax-digital-for-income-tax#check-what-is-included-in-your-qualifying-income).

### Self-employed sole trader income

If the customer is working for themselves, they are a sole trader. For more information on identifying self-employed sole traders, refer to [Working for yourself](https://www.gov.uk/working-for-yourself?step-by-step-nav=01ff8dbd-886a-4dbb-872c-d2092b31b2cf). Currently, self-employment income refers to sole trader self-employment income and not income earned through partnerships. This exclusion also applies to directors of limited companies.

### Property income

A customer’s property income includes the following:

* rental income and other receipts from UK land or property
* rental income and other receipts from foreign land or property
* income from letting furnished rooms in customer’s own home
* income from furnished holiday lettings (FHL) and non-furnished holiday lettings (non-FHL) in the UK
* premiums from leasing UK land
* inducements to take an interest in letting a property (a reverse premium)

For more information on property income, refer to [Work out your rental income when you let property](https://www.gov.uk/guidance/income-tax-when-you-rent-out-a-property-working-out-your-rental-income).

## Retrieving obligations

An MTD mandated or voluntary customer will have a set of obligations for each tax year. These are:

* four quarterly updates
* final declaration 

At any time of the year, customers can check their obligations. To provide this information, the software needs details about their business income sources. It gets this information by using the [List All Businesses](/api-documentation/docs/api/service/business-details-api/1.0/oas/page#/paths/~1individuals~1business~1details~1%7Bnino%7D~1list/get) endpoint, which provides the business ID. This ID is required to call multiple self-employment and property endpoints. To save time, the software should store this ID instead of making extra calls.

Quarterly obligations are created for sole trader and property income sources. In software, the retrieval of customer’s obligations is done by calling any of the following endpoints depending on the customer’s type of income source:

* [Retrieve Income Tax (Self Assessment) Income and Expenditure Obligations](/api-documentation/docs/api/service/obligations-api/2.0/oas/page#/paths/~1obligations~1details~1%7Bnino%7D~1income-and-expenditure/get)
* [Retrieve Income Tax (Self Assessment) Final Declaration Obligations](/api-documentation/docs/api/service/obligations-api/2.0/oas/page#/paths/~1obligations~1details~1%7Bnino%7D~1crystallisation/get)

These endpoints provide obligation dates for all self-employment and property businesses, and inform whether or not obligations have been met. The deadline for meeting a quarterly obligation is one month after the obligation period end date. The software should communicate these deadlines clearly to the customer and prompt them to submit the information when the update is due. 

A customer should always be able to view their latest obligations. To do this, the software should be aware that the customer’s obligation will be created or updated for the following reasons:

* start of financial year
* when a customer submits updates
* when a customer adds a new sole trader business in HMRC online services
* when a customer ceases an existing business in HMRC online services

## Submit income and expense updates for self-employment and property businesses

MTD mandated and voluntary customers must maintain digital records of their self employment and property business income and expenses every quarter. If they wish, they can also submit summary-level information more frequently, for example, monthly. They should not cannot submit summaries that span multiple obligation periods. If they do, the software will need to send two updates, one for each obligation period. For example:

- **Update 1.** 6 April to 1 May is accepted.
- **Update 2.** 2 May to 31 May is accepted.
- **Update 3.** 28 May to 6 June is rejected because it overlaps with previous updates.

The software should convert transactional information into summary totals. It should categorise these totals as income or expenses. The software will send this summary information to HMRC for each mandated income source. HMRC can then use this information to calculate taxes based on the most recent data.

When the tax calculation is triggered, it means that the quarterly obligation has been fulfilled if the data covers the entire period. It can take up to 1 hour for the obligation to be confirmed as met. Customers can also check the status of their obligations through HMRC online services.

<a href="figures/submit-periodics.svg" target="blank"><img src="figures/submit-periodics.svg" alt="submit periodics diagram" style="width:720px;" /></a>

<a href="figures/submit-periodics.svg" target="blank">Open the submit periodics diagram in a new tab</a>.

1. The software prompts the customer when they are due to submit an update. This prompt will not be sent from any API.
2. The customer receives the prompt in the software and begins their submission process.
3. Software prepares the summary information and displays it to the customer.
4. The customer checks the information and submits it.
5. The software initiates the data submission process by calling one of the following endpoints, depending on the income source type being submitted:
   - [Create a Self-Employment Period Summary](/api-documentation/docs/api/service/self-employment-business-api/3.0/oas/page#tag/Self-Employment-Period-Summaries/paths/~1individuals~1business~1self-employment~1{nino}~1{businessId}~1period/post)
   - [Create a UK Property Income and Expenses Period Summary](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/UK-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1uk~1{nino}~1{businessId}~1period~1{taxYear}/post)
   - [Create a Foreign Property Income and Expenses Period Summary](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Foreign-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1foreign~1{nino}~1{businessId}~1period~1{taxYear}/post)
   - [Create a Historic FHL UK Property Income and Expenses Period Summary](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-FHL-UK-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1uk~1period~1furnished-holiday-lettings~1{nino}/post)
   - [Create a Historic Non-FHL UK Property Income and Expenses Period Summary](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-non-FHL-UK-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1uk~1period~1non-furnished-holiday-lettings~1{nino}/post)
6. HMRC receives and stores information and provides a success response.
7. The software receives the success response and confirms with the customer that the update has been received and stored by HMRC.
8. Customer views the confirmation.
9. The software calls the [Trigger a Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1{nino}~1self-assessment~1{taxYear}/post) endpoint to ensure the obligation is marked as met, once the update completes an obligation period. 
10. HMRC receives the request and returns a Calculation ID (`calculationId`). 
11. The software receives the Calculation ID and stores it for future use.
12. The software can also use this Calculation ID to call the [Retrieve a Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1{nino}~1self-assessment~1{taxYear}~1{calculationId}/get) endpoint and display the calculation to the customer. However, this step is optional and the software does not have to retrieve the tax calculation information at this point.

## Construction Industry Scheme

Under the Construction Industry Scheme (CIS), [contractors](https://www.gov.uk/what-you-must-do-as-a-cis-contractor) deduct money from a [subcontractor's](https://www.gov.uk/what-you-must-do-as-a-cis-subcontractor) payments and send it to HM Revenue and Customs (HMRC). 

Currently, under Self Assessment, a subcontractor submits their deductions on their Self-Assessment return and it is checked against HMRC records with what their contractor(s) have submitted. 

Under Making Tax Digital for ITSA, a customer can view what has been submitted by their contractor through their HMRC online services account or their software. Customers can complete the following tasks on their CIS deductions:

- [view CIS deductions](#view-cis-deductions)
- [create CIS deductions](#create-cis-deductions)
- [amend CIS deductions](#amend-cis-deductions)
- [delete CIS deductions](#delete-cis-deductions)

### View CIS deductions

A customer, at any time, can view a breakdown of all the CIS deductions that have been reported to HMRC by their contractors. In software, this is done by calling the [Retrieve CIS Deductions for Subcontractor](/api-documentation/docs/api/service/cis-deductions-api/2.0/oas/page#/paths/~1individuals~1deductions~1cis~1%7Bnino%7D~1current-position~1%7BtaxYear%7D~1%7Bsource%7D/get) endpoint.

<a href="figures/cis-retrieve-cis.svg" target="blank"><img src="figures/cis-retrieve-cis.svg" alt="CIS create diagram" style="width:720px;" /></a>
<a href="figures/cis-retrieve-cis.svg" target="blank">Open the CIS retrieve deduction diagram in a new tab</a>.

When the customer submits quarterly updates to HMRC through their software, they will not be required to provide a CIS deduction amount. When a quarterly update has been made, the software will trigger the tax calculation using the [Trigger a Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D/post) endpoint and display the calculation result to the customer using the [Retrieve A Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D~1%7BcalculationId%7D/get) endpoint. This calculation result will include the CIS deductions received by the contractor for that quarter.

If the customer does not agree with the amount the contractor has submitted to HMRC for any of their quarterly updates, HMRC advises them to query any discrepancies with their contractor. 

### Create CIS deductions

At the end of the year, if the customer still does not agree with the CIS deductions amount the contractor has submitted to HMRC, they can submit what they believe to be the correct amount. This needs to be completed following the fourth quarterly update and before the end-of-period statement is submitted. In software, this is done by calling the [Create CIS Deductions for Subcontractor](/api-documentation/docs/api/service/cis-deductions-api/2.0/oas/page#/paths/~1individuals~1deductions~1cis~1%7Bnino%7D~1amendments/post) endpoint. After successfully creating CIS deductions for the customer, the API returns a submission ID in the success response. This ID must be used to amend or delete CIS deductions in the future. A customer might also submit their CIS deductions amount if they find that no data from the contractor is included in the tax calculation.

<a href="figures/cis-create-cis.svg" target="blank"><img src="figures/cis-create-cis.svg" alt="CIS create diagram" style="width:720px;" /></a>
<a href="figures/cis-create-cis.svg" target="blank">Open the CIS create deduction diagram in a new tab</a>

### Amend CIS deductions

If the customer has submitted a CIS deduction amount after the end of the year but later realises what they submitted was incorrect, they can provide the correct CIS deduction amount. This amendment can be made even after the end-of-period statement is submitted. However, it needs to be done before the final declaration is submitted. In software, amending CIS deductions is done by calling the [Amend CIS Deductions for Subcontractor](/api-documentation/docs/api/service/cis-deductions-api/2.0/oas/page#/paths/~1individuals~1deductions~1cis~1%7Bnino%7D~1amendments~1%7BsubmissionId%7D/put) endpoint.

<a href="figures/cis-amend-cis.svg" target="blank"><img src="figures/cis-amend-cis.svg" alt="CIS amend diagram" style="width:720px;" /></a>
<a href="figures/cis-amend-cis.svg" target="blank">Open the CIS amend deduction diagram in a new tab</a>

### Delete CIS deductions

If the customer has submitted a CIS deduction amount after the end of the year but later realises they did not pay any CIS deductions and what they submitted was incorrect, they can delete the amount. This deletion can be made even after the end-of-period statement is submitted. However, it needs to be done before the final declaration is submitted. In software, deleting CIS deductions is done by calling the [Delete CIS Deductions for Subcontractor](/api-documentation/docs/api/service/cis-deductions-api/2.0/oas/page#/paths/~1individuals~1deductions~1cis~1%7Bnino%7D~1amendments~1%7BsubmissionId%7D/delete) endpoint.

<a href="figures/cis-delete-cis.svg" target="blank"><img src="figures/cis-delete-cis.svg" alt="CIS delete diagram" style="width:720px;" /></a>
<a href="figures/cis-delete-cis.svg" target="blank">Open the CIS delete deduction diagram in a new tab</a>

## Submit allowance and adjustment updates for SE and property businesses

An annual summary is defined as a set of summary data for a tax year, containing allowances and adjustments broken down by category.

Annual updates are mandatory annually but we have provided the functionality for customers to provide information more frequently if they choose.

* amend a [Self-Employment Annual Submission](/api-documentation/docs/api/service/self-employment-business-api/3.0/oas/page#tag/Self-Employment-Annual-Submission/paths/~1individuals~1business~1self-employment~1%7Bnino%7D~1%7BbusinessId%7D~1annual~1%7BtaxYear%7D/put) - this enables the customer to provide any information about allowances and adjustments they might want to provide during the year to get a more accurate calculation
* amend a [Historic Non-FHL UK Property Business Annual Submission](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-non-FHL-UK-Property-Business-Annual-Submission/paths/~1individuals~1business~1property~1uk~1annual~1non-furnished-holiday-lettings~1%7Bnino%7D~1%7BtaxYear%7D/put) - this enables the customer to provide any information about allowances and adjustments they might want to provide during the year to obtain a more accurate calculation
* amend a [Historic FHL UK Property Business Annual Submission](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-FHL-UK-Property-Business-Annual-Submission/paths/~1individuals~1business~1property~1uk~1annual~1furnished-holiday-lettings~1%7Bnino%7D~1%7BtaxYear%7D/put) - this enables the customer to provide any information about allowances and adjustments they might want to provide during the year to obtain a more accurate calculation

## Retrieve a tax calculation

The software will need to use that Calculation ID when calling each endpoint within the [Individual Calculations API](/api-documentation/docs/api/service/individual-calculations-api/).

A calculation result once created (excluding metadata) is an immutable calculation that provides a calculation result at a particular point in time. Any further income updates will require a new calculation to be triggered.

The [Individual Calculations API](/api-documentation/docs/api/service/individual-calculations-api/) allows the software to, choose which elements of the tax calculation it wants to retrieve and play back to the customer:

* [List Self Assessment Tax Calculations](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment/get) for a given National Insurance number (NINO) and tax year
* [Trigger a Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D/post) for a given tax year. The software must use the trigger a self-assessment tax calculation endpoint to inform HMRC that the user has finished submitting their information. As a response, HMRC will provide a Calculation ID (calculationId).
* The triggering of the tax calculation will mark the obligation as fulfilled, if HMRC has data covering the whole period.
* [Retrieve Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D~1%7BcalculationId%7D/get) for a given CalculationID

**Notes:**

* It can take around 5 seconds for the tax calculation response to be ready to retrieve. To avoid getting an error, wait at least 5 seconds before retrieving the calculation. 
* It is possible to return both in-year and final declaration calculations using these endpoints. An in-year calculation is worked out if the calculation was triggered by the [Trigger a Self Assessment Tax Calculation](/api-documentation/docs/api/service/individual-calculations-api/5.0) endpoint

## Making changes to previously submitted data

If a customer wants to make a change to the data that was included in a previously submitted update, customers should make the changes to the digital records and software to recalculate the summary totals and submit to HMRC using the following endpoints:

### For income and expense updates (quarterly)

If a customer makes a change to a previously submitted periodic update, we suggest you call the following:

* [List Self-Employment Period Summaries](/api-documentation/docs/api/service/self-employment-business-api/3.0/oas/page#tag/Self-Employment-Period-Summaries/paths/~1individuals~1business~1self-employment~1%7Bnino%7D~1%7BbusinessId%7D~1period/get)
* [List Historic Non-FHL UK Property Income & Expenses Period Summaries](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-non-FHL-UK-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1uk~1period~1non-furnished-holiday-lettings~1%7Bnino%7D/get) or [List Historic FHL UK property Income & Expenses Period Summaries](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-FHL-UK-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1uk~1period~1furnished-holiday-lettings~1%7Bnino%7D/get) (depending on business income type) to get the period ID and check the update period date range, to ensure any changes are made to the exact date range otherwise it will be rejected.

Customers can also update their summary totals before the end of their obligation period. To do this, the software should call any of the following endpoints, depending on the customers’ type of income source:

- [Amend a Self-Employment Period Summary](/api-documentation/docs/api/service/self-employment-business-api/3.0/oas/page#tag/Self-Employment-Period-Summaries/paths/~1individuals~1business~1self-employment~1{nino}~1{businessId}~1period~1{periodId}/put)
- [Amend a UK Property Income & Expenses Period Summary](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/UK-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1uk~1{nino}~1{businessId}~1period~1{taxYear}~1{submissionId}/get)
- [Amend a Foreign Property Income & Expenses Period Summary](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Foreign-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1foreign~1{nino}~1{businessId}~1period~1{taxYear}~1{submissionId}/put)
- [Amend a Historic FHL UK Property Income & Expenses Period Summary](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-FHL-UK-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1uk~1period~1furnished-holiday-lettings~1{nino}~1{periodId}/put)
- [Amend a Historic Non-FHL UK Property Income & Expenses Period Summary](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-non-FHL-UK-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1uk~1period~1non-furnished-holiday-lettings~1{nino}~1{periodId}/put)

When a business resubmits an update period, the software will have to use the trigger a calculation endpoint and follow the same process as the submitting an update period process.

### For allowance and adjustment updates (annual)

Use the same endpoints and process for submitting annual information as mentioned.

* [Create and Amend Self-Employment Annual Submission](/api-documentation/docs/api/service/self-employment-business-api/3.0/oas/page#tag/Self-Employment-Annual-Submission/paths/~1individuals~1business~1self-employment~1%7Bnino%7D~1%7BbusinessId%7D~1annual~1%7BtaxYear%7D/put)
* [Create and Amend a Historic Non-FHL UK Property Business Annual Submission](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-non-FHL-UK-Property-Business-Annual-Submission/paths/~1individuals~1business~1property~1uk~1annual~1non-furnished-holiday-lettings~1%7Bnino%7D~1%7BtaxYear%7D/put)
* [Create and Amend a Historic FHL UK Property Business Annual Submission](/api-documentation/docs/api/service/property-business-api/3.0/oas/page#tag/Historic-FHL-UK-Property-Business-Annual-Submission/paths/~1individuals~1business~1property~1uk~1annual~1furnished-holiday-lettings~1%7Bnino%7D~1%7BtaxYear%7D/put)

**Note:** Where a business resubmits an annual summary update, previous figures that have been submitted must be sent again as well as any additional information. A zero or empty filed will overwrite previously provided information. The software will have to use the trigger a calculation endpoint and follow the same process.

### Key points for changing previously submitted updates

* changes to periodic updates - the update period you are trying to change must match the original update period exactly, or it will be rejected
* changes to annual updates - all figures previously supplied must be provided again, a zero or a null will overwrite any previously submitted information


## Finalise business income End of Period Statement (EOPS)

**Note:** From December 2024, the EOPS obligation will be removed for MTD customers. However, until that time, this guidance aims to support you with taking any customers who wish to complete their final declaration through the EOPS process.

End of period statement (EOPS) is the process that allows the customer to finalise the profit or loss for any one source of business income. An EOPS must be completed for each source of business income the taxpayer has (just as the current Income Tax process for the UK property, foreign property and self employment or sole trader business). For example, if a customer has one self-employment business and one property business they will have to complete two EOPS.

EOPS can be completed anytime after the end of the tax year but before the 31 January deadline. HMRC would like to encourage this behaviour where possible as it helps customers meet their obligations on time. However, the deadline to complete is 31 January, Year 2.

As part of the EOPS process, customers must ensure that they have provided all the periodic updates and any additional information associated with their self-employed sole trader and/or property business income. They must make sure they are confident with the information they have provided and add any additional information they have. This is likely to include tax and accounting adjustments, allowances or reliefs.

### End-of-Period Statement User Journey

<a href="figures/eops.svg" target="blank"><img src="figures/eops.svg" alt="end of period statement diagram" style="width:720px;" /></a>
<a href="figures/eops.svg" target="blank">Open the EOPS diagram in a new tab</a>.

1. The customer needs to submit any annual allowances and/or adjustments if they have them. In software, this submission is made by calling the relevant annual submission endpoints in the [Self-Employment Business (MTD)](/api-documentation/docs/api/service/self-employment-business-api/) API or [Property Business (MTD)](/api-documentation/docs/api/service/property-business-api/) API, depending on the customer’s income source.
2. The customer can review the data they have submitted. In software, this retrieval is made by calling the [Business Source Adjustable Summary (MTD)](/api-documentation/docs/api/service/self-assessment-bsas-api/) API.
3. The customer can make any accounting adjustments to their periodic submissions. In software, this amendment is made by calling the [Business Source Adjustable Summary (MTD)](/api-documentation/docs/api/service/self-assessment-bsas-api/) API.
4. The customer is encouraged to review the Business Income Source Summary (BISS) information before submitting their EOPS. In software, this information can be retrieved in one of two ways. The software can either choose to create a BISS from data stored locally or the software can use the [Business Income Source Summary (BISS)](/api-documentation/docs/api/service/self-assessment-biss-api) API to retrieve the BISS information from HMRC.
5. The software is encouraged to display the following information to the customer. This allows the customer to confirm it is complete and correct for that source of business income before they send the declaration.
    * Total Business Income
    * Total Expenses
    * Business Net Profit
    * Business Net Loss
    * Total Additions to net profit or deductions to a net loss
    * Total Deductions to net profit or additions to a net loss
    * Accounting Adjustments
    * Taxable Profit
    * Taxable Loss

6. The customer can then go ahead and submit their end-of-period statement for the business income source. In software, this submission is done by calling the [Submit End of Period Statement for a Business](/api-documentation/docs/api/service/individuals-business-eops-api/3.0/oas/page#/paths/~1individuals~1business~1end-of-period-statement~1%7Bnino%7D/post) endpoint.
7. After a successful submission, HMRC receives the declaration and provides a success response.
8. The software must communicate to the customer that the update has been received and stored by HMRC. In order to confirm this submission, the software can call the [Retrieve Income Tax (Self Assessment) End of Period Statement Obligations](/api-documentation/docs/api/service/obligations-api/2.0/oas/page#/paths/~1obligations~1details~1%7Bnino%7D~1end-of-period-statement/get) endpoint.

The exact text that HMRC requires the software to present during EOPS declaration is shown below. Developers must replace ‘[insert tax year]’ with the correct tax year.

### Declaration for Agents

 > **Declaration for Self Employment EOPS**

> "I confirm that my client has reviewed the information provided to establish the taxable profits for the relevant period ending in [insert tax year] together with the designatory data provided for that period and that it is correct and complete to the best of their knowledge. They understand that they may have to pay financial penalties or face prosecution if they give false information."

 > **Declaration for Property EOPS**

> "I confirm that my client has reviewed the information provided to establish taxable profits for the relevant period ending in [insert tax year] together with the designatory data for that period and that it is correct and complete to the best of their knowledge. They understand that they may have to pay financial penalties or face prosecution if they give false information."


### Declaration for Individuals

 > **Declaration for Self Employment EOPS**

> “I confirm that I have reviewed the information provided to establish the taxable profits for the relevant period ending in [insert tax year] together with the designatory data provided for that period and that it is correct and complete to the best of my knowledge. I understand that I may have to pay financial penalties or face prosecution if I give false information.”

> **Declaration for Property EOPS**

> “I confirm that I have reviewed the information provided to establish taxable profits for the relevant period ending in [insert tax year] together with the designatory data for that period and that it is correct and complete to the best of my knowledge. I understand that I may have to pay financial penalties or face prosecution if I give false information.”


**Note:** Making changes to data for previously submitted periods is covered in the "[making changes to previously submitted data"](/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#making-changes-to-previously-submitted-data) section.

## View previously submitted updates

A customer may want to retrieve previously submitted data, for example before making a change the customer may want to request the last update provided before sending in any changes. If the customer has recently started using your software, you may need to retrieve previous data.

### Income and expense updates (Periodic)

The software can use the list all self-employment or property update periods endpoints to retrieve the list of updates made for that income source, or to find one or more period IDs. The period ID is then used with the ‘get a self-employment/property (FHL or Non FHL) periodic update’ endpoint to retrieve data for that update.

### Annual accounting adjustments

Within the annual self-assessment process, annual accounting adjustments are applied to income and expenses before the business or agent submits their tax return to HMRC. Within Making Tax Digital as the income and expenses are submitted to HMRC at least quarterly
during the active accounting period, this means a new process to accommodate these adjustments is required.

### Submitting annual accounting adjustments

After an accounting period has ended, a business or agent may need to submit accounting adjustments to the income and expenses that have been submitted throughout the year.

Endpoints to call are:

1. [Trigger a Business Source Adjustable Summary](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1trigger/post).
2. [Retrieve a Self-employment Business Source Adjustable Summary (BSAS)](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Self-employment-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1self-employment~1%7BcalculationId%7D/get), [Retrieve a UK Property Business Source Adjustable Summary (BSAS)](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/UK-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1uk-property~1%7BcalculationId%7D/get) or [Retrieve a Foreign Property Business Source Adjustable Summary (BSAS)](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Foreign-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1foreign-property~1%7BcalculationId%7D/get) - these endpoints provide the totals of all income and expenses submitted for a business that can have adjustments applied to them.
3. Apply the adjustments as appropriate to the total figures returned via the Retrieve BSAS endpoints.
4. [Submit Self-Employment Accounting Adjustments](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Self-employment-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1self-employment~1%7BcalculationId%7D~1adjust/post), [Submit UK Property Accounting Adjustments](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/UK-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1uk-property~1%7BcalculationId%7D~1adjust/post) or [Submit Foreign Property Accounting Adjustments](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Foreign-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1foreign-property~1%7BcalculationId%7D~1adjust/post).

Once submitted, if a further amendment is required, use the [Retrieve a Self-Employment Business Source Adjustable Summary (BSAS)](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Self-employment-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1self-employment~1%7BcalculationId%7D/get), [Retrieve a UK Property Business Source Adjustable Summary (BSAS)](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/UK-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1uk-property~1%7BcalculationId%7D/get) or [Retrieve a Foreign Property Business Source Adjustable Summary (BSAS)](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Foreign-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1foreign-property~1%7BcalculationId%7D/get) endpoints to retrieve the previously submitted data and then repeat steps 3 and 4.

## Business Income Source Summary

The [Self Assessment BISS (Business Income Source Summary) API](/api-documentation/docs/api/service/self-assessment-biss-api/) allows a developer to retrieve a summary of income and expenditure that has been submitted for a specified self-employment or property business (UK or foreign) for a given tax year. The data returned is the equivalent of the existing SA103, SA105 and SA106 schedule.

<a href="figures/biss.svg" target="blank"><img src="figures/biss.svg" alt="BISS (Business Income Source Summary) diagram" style="width:720px;" /></a>

<a href="figures/biss.svg" target="blank">Open the BISS diagram in a new tab</a>.

* [Retrieve a Business Income Source Summary (BISS)](/api-documentation/docs/api/service/self-assessment-biss-api/2.0/oas/page#/paths/~1individuals~1self-assessment~1income-summary~1%7Bnino%7D~1%7BtypeOfBusiness%7D~1%7BtaxYear%7D~1%7BbusinessId%7D/get)

## Business Source Adjustable Summary

The [Self Assessment BSAS (Business Source Adjustable Summary) API](/api-documentation/docs/api/service/self-assessment-bsas-api/) allows a developer to retrieve an adjustable summary calculation for a specified self-employment or property business, for a given accounting period.

This API should be used to submit any Annual Accounting Adjustments. The adjustments should be submitted as positive or negative amounts, for example, if advertising costs in the BSAS is £250 but the figure should be £200, then the adjustment required would be -50.

**Note: Adjustments are always made against the total of the original quarterly updates. Each new adjustment will overwrite the previous adjustment.**

|                      | Original (total of all 4 quarters) | 1<sup>st</sup> adjustment | Revised total | 2<sup>nd</sup> adjustment | Revised total |
|----------------------|------------------------------------|---------------------------|---------------|---------------------------|---------------|
| premisesRunningCosts | 500                                | 25                        | 525           | 23                        | 523           |
| travelCosts          | 600                                | -17                       | 583           | -17                       | 583           |

<a href="figures/bsas.svg" target="blank"><img src="figures/bsas.svg" alt="BSAS (Business Source Adjustable Summary) diagram" style="width:720px;" /></a>

<a href="figures/bsas.svg" target="blank">Open the BSAS diagram in a new tab</a>.

* [List Business Source Adjustable Summaries](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D/get)
* [Trigger a Business Source Adjustable Summary](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1trigger/post)

* [Retrieve a Self-Employment Business Source Adjustable Summary (BSAS)](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Self-employment-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1self-employment~1%7BcalculationId%7D/get)

* [Submit Self-Employment Accounting Adjustments](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Self-employment-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1self-employment~1%7BcalculationId%7D~1adjust/post)
* [Retrieve a UK Property Business Source Adjustable Summary (BSAS)](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/UK-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1uk-property~1%7BcalculationId%7D/get)
* [Submit UK Property Accounting Adjustments](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/UK-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1uk-property~1%7BcalculationId%7D~1adjust/post)
* [Retrieve a Foreign Property Business Source Adjustable Summary (BSAS)](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Foreign-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1foreign-property~1%7BcalculationId%7D/get)
* [Submit Foreign Property Accounting Adjustments](/api-documentation/docs/api/service/self-assessment-bsas-api/4.0/oas/page#tag/Foreign-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1foreign-property~1%7BcalculationId%7D~1adjust/post)


## Multiple businesses

Users with multiple self-employment businesses and those with a foreign property business will be able to sign up to Making Tax Digital. To enable this we are providing a number of new endpoints:

* [List All Businesses](/api-documentation/docs/api/service/business-details-api/1.0/oas/page#/paths/~1individuals~1business~1details~1%7Bnino%7D~1list/get) - returns a list of the business income sources
* [Retrieve Business Details](/api-documentation/docs/api/service/business-details-api/1.0/oas/page#/paths/~1individuals~1business~1details~1%7Bnino%7D~1%7BbusinessId%7D/get) - returns further information about a single business income source
* [Retrieve Income Tax (Self Assessment) Income and Expenditure Obligations](/api-documentation/docs/api/service/obligations-api/2.0/oas/page#/paths/~1obligations~1details~1%7Bnino%7D~1income-and-expenditure/get) - returns the quarterly obligations for each business income source
* [Retrieve Income Tax (Self Assessment) End of Period Statement Obligations](/api-documentation/docs/api/service/obligations-api/2.0/oas/page#/paths/~1obligations~1details~1%7Bnino%7D~1end-of-period-statement/get) - returns the End of Period Statement obligations for a user’s business income sources
* [Retrieve Income Tax (Self Assessment) Final Declaration Obligations](/api-documentation/docs/api/service/obligations-api/2.0/oas/page#/paths/~1obligations~1details~1%7Bnino%7D~1crystallisation/get) - returns the final declaration obligation for a user
* [Amend Loss Claims Order](/api-documentation/docs/api/service/individual-losses-api/4.0/oas/page#tag/Loss-Claims/paths/~1individuals~1losses~1%7Bnino%7D~1loss-claims~1order~1%7BtaxYearClaimedFor%7D/put) - permits a change in the order in which loss claims are consumed

<a href="figures/list-all-businesses.svg" target="blank"><img src="figures/list-all-businesses.svg" alt="list all businesses diagram" style="width:720px;" /></a>
<a href="figures/list-all-businesses.svg" target="blank">Open the list all businesses diagram in a new tab</a>.

Property unspecified in the Gov test scenario means where we are unable to identify the type of property business - whether UK or foreign. In exceptional cases, we return a type of "property-unspecified".
In the case where the query is made with a validly formed but incorrect National Insurance number for a user a “not found” can be returned.

<a href="figures/retrieve-business-details.svg" target="blank"><img src="figures/retrieve-business-details.svg" alt="retrieve business details diagram" style="width:720px;" /></a> <a href="figures/retrieve-business-details.svg" target="blank">Open the retrieve details businesses diagram in a new tab</a>.

<a href="figures/multiple-businesses-retrieve-itsa-income-expenditure-obligations.svg" target="blank"><img src="figures/multiple-businesses-retrieve-itsa-income-expenditure-obligations.svg" alt="retrieve business details diagram" style="width:720px;" /></a> <a href="figures/multiple-businesses-retrieve-itsa-income-expenditure-obligations.svg" target="blank">Open the retrieve Income Tax (Self Assessment) income and expenditure diagram in a new tab</a>.
In the case where the query is made with a validly formed but incorrect National Insurance number for a user a “not found” can be returned.

<a href="figures/multiple-businesses-retrieve-itsa-eops-statement.svg.svg" target="blank"><img src="figures/multiple-businesses-retrieve-itsa-eops-statement.svg" alt="multiple businesses diagram" style="width:720px;" /></a>
<a href="figures/multiple-businesses-retrieve-itsa-eops-statement.svg" target="blank">Open the retrieve Income Tax (Self Assessment) End of Period Statement obligations diagram in a new tab.</a>

<a href="figures/multiple-businesses-retrieve-income-tax-crystallisation-obligations.svg" target="blank"><img src="figures/multiple-businesses-retrieve-income-tax-crystallisation-obligations.svg" alt="multiple businesses diagram" style="width:720px;" /></a>
<a href="figures/multiple-businesses-retrieve-income-tax-crystallisation-obligations.svg" target="blank">Open the retrieve Income Tax (Self Assessment) final declaration obligations diagram in a new tab.</a>

The [List Loss Claims](/api-documentation/docs/api/service/individual-losses-api/4.0/oas/page#tag/Loss-Claims/paths/~1individuals~1losses~1%7Bnino%7D~1loss-claims~1tax-year~1%7BtaxYearClaimedFor%7D/get) endpoint has been extended to include a sequence number that shows the order in which loss claims will be used.

A user with multiple businesses may choose to list their businesses so that they can obtain the Business IDs of their active businesses. A developer can then return information about a specific business or retrieve obligations quoting a ```businessID```, so the user knows when they need to submit information.

Where more than one business income source has incurred a loss at the end of the tax year and the user has opted to carry-sideways these losses (by listing loss claims) they will see the current order in which these loss claims will be applied.  If they wish to change the order they can amend the loss claim order preference and list loss claims to review.

Not all loss claims will have a sequence number to indicate the order of use (currently only carry-sideways, future functionality will enable you to carry backwards). When changing the order, all the loss claims of the same type (for example carry-sideways) must be included in the submission.

To obtain the ```businessID``` a developer will need to call the [List All businesses](/api-documentation/docs/api/service/business-details-api/1.0/oas/page#/paths/~1individuals~1business~1details~1%7Bnino%7D~1list/get) endpoint.  This will then permit obligations to be retrieved for a particular Business ID so that the user is clear by when they must submit their business data.
Once loss claims have been generated a user will be able to list them and determine if the order in which they are used needs to change.

