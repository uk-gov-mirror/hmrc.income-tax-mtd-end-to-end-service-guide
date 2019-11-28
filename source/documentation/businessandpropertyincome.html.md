---
title: Business and property income
weight: 3
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Business and property income

The steps in this section (up to end of period statement) will be the element that will be mandated under MTD 


## Receive obligations

Once a business or agent has completed authentication and granted access to the software, the software can then use our APIs to request the information the customer provided at sign up and to find out the customer’s update obligation dates. The software must make customers aware of their obligations.

Actions to take are as follows:

* the [list all self-employment businesses](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#selfemployment-business_list-all-selfemployment-businesses_get_accordion) endpoint provides a list of all the customer’s self-employment businesses, along with the Self employment ID   which the software will need to send to HMRC (this is currently limited to one but functionality to add more will be available later and stated in the roadmap)
* the [Get a self-employment business](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#selfemployment-business_get-a-selfemployment-business_get_accordion) or [Get a UK property Business](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#uk-property-business_get-a-uk-property-business_get_accordion) endpoint will provide the information HMRC holds for a specific self-employment or property business
Customers can find out their obligations for their income source, through the following endpoints:
* [retrieve self-employment business obligations](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#selfemployment-business_retrieve-selfemployment-business-obligations_get_accordion) - provides obligation dates for all self-employment businesses, including grace periods and whether obligations have been met or not 
* [retrieve all UK property business obligations](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#uk-property-business_retrieve-all-uk-property-business-obligations_get_accordion) endpoint provides obligation dates for their UK property, including grace periods and whether obligations have been met or not 

Note: the obligations for property obligations cover both FHL and Non FHL

## Submit Periodic updates for Self Employment and property businesses

Businesses, and agents who represent them, will be required to provide summary level information of their business income and expenses (transactional information to be kept digitally) on a quarterly basis or more often if they choose.

The quarterly obligations are initially created based on the accounting period for the income source. The deadline for meeting a quarterly obligation is one month after the obligation period end date. Software should communicate these deadlines clearly to the customer. Submissions of summary level information cannot span an obligation period, if it does software will need to send 2 updates that fall into different obligations.  

The software package will need to convert the transactional information into summary totals for each category, for example expenses by category.

HMRC has provided APIs to enable software to be able to send the summary information to HMRC for each income source and allow HMRC to provide a calculation based on all the information we have received to date.

When the update is received, HMRC checks if the customer is signed up to MTD and if the submission is coming from an agent,  if that agent is subscribed to agent services and authorised to act on behalf of the client. if not an error is returned. 

If the agent is subscribed, HMRC checks if the agent is authorised to act on behalf of that customer.

The service will include a number of business validation rules to ensure that all submissions are cross-validated before being accepted. HMRC cannot apply these rules without knowing that no further submission (APIs calls) will be sent by the customer for the period being validated.

Once all the information has been submitted to HMRC for that period, the software must use the [trigger a tax calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#tax-calculations_trigger-a-tax-calculation_post_accordion) endpoint to inform HMRC that the user has finished submitting their information. As a response HMRC will provide a Calculation ID (calculationId).

The triggering of the tax calculation will mark the obligation as fulfilled, if we have data covering the whole period. 

Note: 

*	This does not need to be provided in one go, Customers can submit data as frequently as they like (i.e monthly) 
*	This does not mean the customer has to declare that the submissions are ‘complete and correct’ (there is no ‘accuracy’ statement required at this point), only that the customer must indicate that they do not intend to provide any additional information at this point. There is nothing to stop them providing additional information anytime by resubmitting the update period with any changes that have been made to the previous submission.

*	In some cases, the obligation can take up to an hour to be confirmed as met. 
*	This met obligation must be presented clearly to the customer in software. 
*	Customers can  also check this information in their Business Tax Account. 
*	The customer will not receive any communication from HMRC to confirm that the obligation has been met. 
*	For property businesses, an update for either FHL or Non FHL for the full quarter will mark the obligation as fulfilled, even if they have both income types. 

Software will need to use the following endpoints for each relevant source of income. For quarterly updates:

*	create a self-employment update period - this creates the update period and enables software to provide the summary totals of income and expenses for that specific self-employment business (this could be as little as a day or the whole 3 month obligation period)

The Calculation ID response includes:

* a ‘year to date’ estimated liability (which will total all period calculations to give an up to date view of the estimated
liability)
* a breakdown of how the estimated liability has been reached - at a minimum it will be the equivalent to an SA302
* a forecast figure of what the customer’s liability is likely to be at the end of the year based on the information provided to date. Customers will not be able to change this forecast figure as it is for information only.
Software can then call the relevant Get obligations APIs to establish whether or not the customer’s obligation has been met.
Note: In some cases, the obligation can take up to an hour to be confirmed as met.
This met obligation must be presented clearly to the customer in software. They will also check this information in their Business Tax Account. The customer will not receive any communication from HMRC to confirm that the obligation has been met. 
When a customer wants to send an update for a self-employment or property business, the software will need to provide summary totals for any income or expenses by category (mandatory quarterly) and allowances and adjustments (mandatory annual).

Software will need to use the following endpoints for each relevant source of income. For quarterly updates:

*	create a self-employment update period - this creates the update period and enables software to provide the summary totals of income and expenses for that specific self-employment business (this could be as little as a day or the whole 3 month obligation period)
*	create a Furnished Holiday Lettings (FHL) property period - this creates the update period and enables software to provide the summary totals of income and expenses for FHL property income
*	create a non FHL property update period- this creates the update period and enables software to provide the summary totals of income and expenses for non FHL property income A customer can provide the information as frequently as they need, however there are a couple of validation rules that apply.

Each update period cannot overlap the previous one, for example:

Update 1 – 6 April to 1 May is accepted<br />
Update 2 – 2 May to 31 May is accepted<br />
Update 3 – 28 May to 6 June is rejected because it overlaps with previous updates

## Submit Annual updates for SE and Property businesses

Annual updates are mandatory annually but we have provided the functionality for customers to provide information more frequently if they choose. 

* update a [self-employment annual summary](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#selfemployment-business_get-a-selfemployment-annual-summary_get_accordion) - this enables the customer to provide any information about allowances and adjustments they might want to provide during the year to get a more accurate calculation 
* update a [non FHL property business annual summary](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#uk-property-business_amend-a-nonfhl-uk-property-business-annual-summary_put_accordion) - this enables the customer to provide any information about allowances and adjustments they might want to provide during the year to get a more accurate calculation 
* update an [FHL property business annual summary](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#uk-property-business_amend-a-fhl-uk-property-business-annual-summary_put_accordion) - this enables the customer to provide any information about allowances and adjustments they might want to provide during the year to get a more accurate calculation 

## Retrieve a tax calculation 

Software will need to use that Calculation ID when calling the retrieve a tax calculation endpoint to get the calculation result. 
The Calculation ID response includes:

*	a ‘year to date’ estimated liability (which will total all period calculations to give an up to date view of the estimated liability)
*	a breakdown of how the estimated liability has been reached - at a minimum it will be the equivalent to an SA302
*	a forecast figure of what the customer’s liability is likely to be at the end of the year based on the information provided to date. Customers will not be able to change this forecast figure as it is for information only. 
*	Software can then call the relevant Get obligations APIs to establish whether or not the customer’s obligation has been met. 

Note: 

This step in the process is being replaced by a new Individual Calculation API – this new API will be going live in December 
This step will be withdrawn on XX MONTH XXXX

### Individual Calculation API

* Software should use that Calculation ID to call the individual calculation endpoint a tax calculation API endpoint to get the result of the calculation.

[NEED INFO ABOUT HOW TAX CACL WILL WORK HERE]

The [Individual calculations API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0) allows software to, choose which elements of the tax calculation it wants to retrieve and play back to the customer

* [list self-assessment tax calculations](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_list-self-assessment-tax-calculations-test-only_get_accordion) for a given National Insurance number (NINO) and tax year
*	trigger a self-assessment tax calculation for a given tax year. This will replace the trigger tax calculation element of the process listed in the periodic updates section. The result of the calculation can be explored through the [Retrieve a self-assessment tax calculation metadata endpoint](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-metadata-test-only_get_accordion)
*	[retrieve high-level calculation metadata](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-metadata-test-only_get_accordion) for a given CalculationID 
*	[retrieve the calculated Income Tax and National Insurance contributions](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-income-tax-and-nics-calculated-test-only_get_accordion) for a given NINO and Calculation ID
*	[retrieve the taxable income](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-taxable-income-test-only_get_accordion) that has been used in the self-assessment tax calculation for a given NINO and Calculation ID
*	[retrieve the allowances, deductions and reliefs](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-allowances-deductions-and-reliefs-test-only_get_accordion) that exist for the self-assessment tax calculation for a given NINO and Calculation ID
*	[retrieve the end-of-year Income Tax and National Insurance contribution estimates](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-end-of-year-estimate-test-only_get_accordion) for a given NINO and Calculation ID
*	[retrieve “info”, “warning” and “error” level messages](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-messages-test-only_get_accordion) linked to a Calculation ID

A calculation result once created (excluding metadata) is an immutable calculation that provides a calculation result at a particular point in time. Any further income updates will require a new calculation to be triggered.

It is possible to return both in-year and crystallisation calculations using these endpoints.

An in-year calculation is worked out if the calculation was triggered by the [Trigger a self-assessment tax calculation endpoint](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_trigger-a-self-assessment-tax-calculation-test-only_post_accordion). A crystallisation calculation is performed if the calculation was triggered by the intent to crystallise endpoint under the Self Assessment (MTD) API.

For a crystallisation calculation the minimum number of endpoints that need to be called are:

*	[retrieve self assessment tax calculation metadata](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-metadata-test-only_get_accordion)
*	[retrieve self assessment tax calculation taxable income](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-taxable-income-test-only_get_accordion)
*	[retrieve self assessment tax calculation income tax NICs calculated](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-income-tax-and-nics-calculated-test-only_get_accordion)
*	[retrieve self assessment tax calculation allowances, deductions and reliefs](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-allowances-deductions-and-reliefs-test-only_get_accordion) (if applicable)
*	[retrieve self assessment tax calculation messages](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-messages-test-only_get_accordion) (if applicable)

A crystallisation Calculation ID will not always have a calculation result. It is possible that errors in previously submitted income data could prevent a calculation from being performed.

The existing paper based SA302 form fields span the following endpoints in the new Individual Calculations API:

*	retrieve self assessment tax calculation taxable income
*	retrieve self assessment tax calculation Income Tax NICs calculated
*	retrieve self assessment tax calculation allowances, deductions and reliefs

If calculation errors are present, these errors can be returned to the customer by the [retrieve self assessment tax calculation messages](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-messages-test-only_get_accordion) endpoint.

Note: The self-assessment tax calculation endpoints under the Individual Calculations API will eventually replace the tax calculation endpoints under the existing [Self Assessment API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0).



### Retrieve a tax calculation

The [Individual calculations API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0) allows software to:

* [list self-assessment tax calculations](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_list-self-assessment-tax-calculations-test-only_get_accordion) for a given National Insurance number (NINO) and tax year
* trigger a [self-assessment tax calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_trigger-a-self-assessment-tax-calculation-test-only_post_accordion) for a given tax year. The result of the calculation can be explored through the [Retrieve a self-assessment tax calculation metadata](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-metadata-test-only_get_accordion) endpoint
* [retrieve high-level calculation metadata](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-metadata-test-only_get_accordion) for a given Calculation ID
* [retrieve the calculated Income Tax and National Insurance contributions](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-income-tax-and-nics-calculated-test-only_get_accordion) for a given NINO and Calculation ID
* [retrieve the taxable income](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-taxable-income-test-only_get_accordion) that has been used in the self-assessment tax calculation for a given NINO and Calculation ID
* [retrieve the allowances, deductions and reliefs](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-allowances-deductions-and-reliefs-test-only_get_accordion) that exist for the self-assessment tax calculation for a given NINO and Calculation ID
* [retrieve the end-of-year Income Tax and National Insurance contribution](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-end-of-year-estimate-test-only_get_accordion) estimates for a given NINO and Calculation ID
* [retrieve “info”, “warning” and “error” level messages](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-messages-test-only_get_accordion) linked to a Calculation ID

A calculation result once created (excluding metadata) is an immutable calculation that provides a calculation result at a particular point in time. Any further income updates will require a new calculation to be triggered.

It is possible to return both in-year and crystallisation calculations using these endpoints. 

An in-year calculation is worked out if the calculation was triggered by the [Trigger a self-assessment tax calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_trigger-a-self-assessment-tax-calculation-test-only_post_accordion) endpoint. A crystallisation calculation is performed if the calculation was triggered by the [intent to crystallise](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#crystallisation_intent-to-crystallise_post_accordion) endpoint under the Self Assessment (MTD) API. 

For a crystallisation calculation the minimum number of endpoints that need to be called are: 

* [retrieve self assessment tax calculation metadata](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-metadata-test-only_get_accordion)
* [retrieve self assessment tax calculation taxable income](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-taxable-income-test-only_get_accordion)
* [retrieve self assessment tax calculation income tax NICs calculated](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-income-tax-and-nics-calculated-test-only_get_accordion)
* [retrieve self assessment tax calculation allowances, deductions and reliefs](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-allowances-deductions-and-reliefs-test-only_get_accordion) (if applicable)
* [retrieve self assessment tax calculation messages](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-messages-test-only_get_accordion) (if applicable)

A Calculation ID will not always have a calculation result. It is possible that errors in previously submitted income data could prevent a calculation from being performed.

The existing paper based SA302 form fields span the following endpoints in the new Individual Calculations API:

* retrieve self assessment tax calculation taxable income
* retrieve self assessment tax calculation Income Tax NICs calculated
* retrieve self assessment tax calculation allowances, deductions and reliefs

If calculation errors are present, these errors can be returned to the customer by the [retrieve self assessment tax calculation messages](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-messages-test-only_get_accordion) endpoint. 

Note: The self-assessment tax calculation endpoints under the Individual Calculations API will eventually replace the tax calculation endpoints under the existing [Self Assessment API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0).


## Finalise business income end of period statement (EOPS)

### Business or Agent able to submit End of Period Statement through software

This is the process that allows the customer to finalise the profit or loss for any one source of business income. An EOPS (End of Period Statement) must be completed for each source of business income the taxpayer has (just as, the current Income Tax process for the SA103 and 105 schedules) so, for example, if a customer has one self-employment business and one property business they will have to complete two EOPS.

EOPS relates to the accounting period or basis period for each source of business income and cannot be completed before the end of that period. The customer can complete their EOPS at any point after the end of the accounting period and do not have to wait until the 31st January deadline. We would like to encourage this behaviour where possible as it helps customers manage their business income in line with the business accounts. However the deadline to complete is  31 January, Year 2. 

The process will take into account all the periodic and annual data already provided by the customer throughout the year.

The customer must make sure they are happy with the information they have provided and add any additional information they have. This is likely to include tax and accounting adjustments, allowances or reliefs.

Note: 

*	Data received must cover the whole accounting period.
* We will be providing an API for customers to provide annual adjustments. 

Software should present to the customer the information listed below. This can  be totalled up by software, or we have provided APIs for you to get it from HMRC systems as well Business Income Source Summary (BISS) for self-employment or property:

* Total Business Income
* Total Expenses
* Business Net Profit
* Business Net Loss
* Total Additions to net profit or deductions to net loss
* Total Deductions to net profit or additions to net loss
* Accounting Adjustments
* Taxable Profit
* Taxable Loss

This information must be shown to the customer for them to confirm it is complete and correct for that source of business income before they send the declaration. 

You could use the Business Income Source Summary APIs or opt to create this information within your package. HMRC will need the declaration to confirm the customer has seen it.

Note: The Declaration is the only mandatory API for this process, the exact text HMRC requires you to present is below

 > **Declaration for Self Employment EOPS**

 > “I confirm that I have reviewed the information provided to establish the taxable profits for the relevant period ending in [insert tax year] together with the designatory data provided for that period and that it is correct and complete to the best of my knowledge. 

 >I understand that I may have to pay financial penalties or face prosecution if I give false information.”

 > **Declaration for Property EOPS**

 > “I confirm that I have reviewed the information provided to establish taxable profits for the relevant period ending in [insert tax year] together with the designatory data, including details of the properties for that period and that it is correct and complete to the best of my knowledge. 

 > I understand that I may have to pay financial penalties or face prosecution if I give false information.”

Making changes to previously submitted data during and after an End of Period Statement declaration

* if the information the customer has previously provided relating to that source of business income is not correct or complete (for example the previous information provided fails further validation or a periodic update is missing) then the EOPS declaration will be rejected and error messages returned.  The changes must be made to any relevant periodic or annual summaries, then follow the existing process of submitting updates and triggering the calculation before attempting the declaration again.

* if there are no error failures it is recommend that customers review any warning messages they have at this point or earlier as warnings will cause a failure at crystallisation.

* if after the customer has completed their EOPS declaration, they need to revise any of the data relating to that source of business income then they must make the change to the relevant periodic or annual summaries, then follow the existing process of submitting updates and triggering the calculation.

Note: making changes to data for previously submitted periods is covered in Make changes {INSERT HYPERLINK] to previously submitted data section 

## View previously submitted updates

A customer may want to retrieve previously submitted data, for example before making a change the customer may want to request the last update provided before sending in any changes. If the customer has recently started using your software, you may need to retrieve previous data.

### Periodic updates

Software can use the list all self employment or property update periods endpoints to retrieve the list of updates made for that income source, or to find one or more period IDs. The period ID is then used with the ‘get a selfemployment/property (FHL or Non FHL) periodic update’ endpoint to retrieve data for that update.

### Annual updates

Annual information can be provided throughout the year but there is only one period a year for the annual summary. Software can use the ‘get a self employment/property (FHL and Non FHL) annual summary) endpoint providing the tax year for the annual period you are looking for.
 
## Make changes to previously submitted data

If a customer wants to make a change to the data that was included in a previously submitted update, customers should make the changes to the digital records and software recalculate the summary totals and submit to HMRC using the  following endpoints:

* for quarterly updates - Amend a self-employment periodic update or Amend a (FHL or Non FHL) property periodic update
* for Annual updates - use the same endpoints: Amend a self-employment annual summary or Amend an (FHL or Non FHL) property business annual summary
For all quarterly updates including self-employment, FHL property business and non-FHL property business:
* software will have to resubmit the new summary totals for the specific update period, the dates of the update period have to match exactly
* 	when a business resubmits an update period, the software will have to use the trigger calculation endpoint and follow the same process as the submitting an update period process 
* 	software will have to resubmit any changes to the summary totals for income source. The nature of this obligation means there is no need to create separate update periods
* 	where a business resubmits an annual summary update, previous figures that have been submitted must be sent again as well as any additional information. A zero or null will overwrite previously provided information
* the software will have to use the [trigger calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#tax-calculations_trigger-a-tax-calculation_post_accordion) endpoint and follow the same process

Note: 

* any changes that are made before the customer has crystallised is not a formal amendment For all changes to annual summary updates including Self-employment, FHL property business and non-FHL property business:

### Key points for changing previously submitted updates

*	changes to Periodic updates - the update period you are trying to change must match the original update period exactly or it will be rejected
*	changes to Annual updates - all figures previously supplied must be provided again, a zero or a null will overwrite any previously submitted information.
