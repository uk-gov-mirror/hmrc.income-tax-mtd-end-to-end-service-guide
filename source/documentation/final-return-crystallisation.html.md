---
title: Final return (crystallisation)
weight: 10
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Final return (crystallisation)

This is the process that allows the customer to finalise their tax position for any one tax year, taking into account all sources of chargeable income and gains, whether business income or otherwise. In other words, this process will bring together all the data that a taxpayer needs to provide to HMRC to reach their final tax liability for a specific year.

It is also the process by which most formal claims for reliefs and allowances and any elections will be made, where these were previously included within a Self Assessment tax return.

Customers will also be able to tell us at this point (subject to the existing limits) how they wish any losses available to them to be treated.

Customers can crystallise from 6 April Year 1. The deadline for Crystallisation is 31 January Year 2. Software should remind customers to help them to meet this deadline.

## Provide information about how to treat a loss

### Annual adjustments 

INSERT ANNUAL ADJUSTMENTS CONTENT HERE

### Losses and Claims

A self-employed business can make a loss when the trade expenses are more than the trade income.
If the business made a loss for a year prior to signing up to Making Tax Digital, the customer or agent will need to submit details of the loss to be brought forward.

<a href="figures/losses-api-diagram.svg" target="blank"><img src="figures/losses-api-diagram.svg" alt="Losses API calls" style="width:520px;" /></a>

<a href="figures/losses-api-diagram.svg" target="blank">Open the Losses diagram in a new tab</a>.

Vendors can use the [brought forward losses](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0) endpoint to enable customers to submit the brought forward loss to HMRC.

When the loss detail has been submitted, or if a loss arises for a tax year following sign up to Making Tax Digital, a claim will need to be made to either:

* utilise the loss against an income source for a specific year, or 
* claim to carry the loss forward so that it is available to use in later years

The [Loss claims](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims) endpoint allows the user to:

* [provide a list of Loss claims](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_list-loss-claims-test-only_get_accordion)
* [create a Loss Claim against an income source for a specific tax year](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_create-a-loss-claim-test-only_post_accordion)
* [show the detail of an existing Loss claim](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_retrieve-a-loss-claim-test-only_get_accordion)
* [delete a previously entered Loss claim](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_delete-a-loss-claim-test-only_delete_accordion)
* [update a previously entered Loss claim](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_amend-a-loss-claim-test-only_post_accordion)

To carry back a loss, the customer should contact HMRC, who will be able to apply this manually.

## Submit information about personal income
### Crystallise liability (SA return)

Software should prompt customers to make sure they have considered the following potential additional income sources (links to the APIs where the functionality has been provided, we will continue to release additional functionality and will update this document when relevant) 

* any income from bank/building society interest (supported in live)
* any income from dividends (supported in live)
*	any gift aid contributions they have made (supported in live)
*	any pension contributions 
*	any pension income
*	capital gains
*	income from employment
*	additional information (currently provided on the SA101)
*	any income from partnerships
*	any income from trusts 
*	any Foreign income 

Note: Any information currently provided via the existing Self Assessment process if a customer needs to report information to HMRC that is not yet supported under MTD, they will need to complete a Self Assessment tax return.

## Crystallisation 

The software will have to let HMRC know that the customer is ready to crystallise, to do this you must call the [intent to crystallise](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#crystallisation_intent-to-crystallise_post_accordion) endpoint. This will start the crystallisation process in HMRC. It will trigger the business validation rules (which will become errors rather than warnings) and generate a final liability calculation.

The intent to crystallise response includes a calculationId the same as the trigger calculation endpoint. Software will then have to retrieve the calculation using calculationId  to retrieve a tax calculation endpoint to get the calculation output.

NEED TO ADD INFO HERE ABOUT THE TAX CALC FOR CRYSTALLISATION AS MENTIONED ABOVE IN TAX CALC SECTION 

The Calculation ID output provides a summary of each income source (for example self-employment, UK Property, UK bank and building society interest), plus a breakdown of allowances and reliefs applied, and a breakdown of the income tax and NIC payable - broadly the equivalent of the current SA302.

Once software has called the [intent to crystallise](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#crystallisation_intent-to-crystallise_post_accordion) endpoint, this will trigger a final liability calculation and software will receive a Calculation ID.

The software must us the intent to crystallise calculationId to retrieve the final calculation and display that calculation to the customer. The customer must review this calculation  and confirm it is complete and correct by sending the declaration.

If the customer thinks the calculation is incorrect as a result of data they have submitted, they can go back and change the information, by resubmitting the relevant update with the correct information. Once they have done this the software will have to call the [intent to crystallise](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#crystallisation_intent-to-crystallise_post_accordion) endpoint again to generate a new final liability.

If the customer does not agree with the calculation based on rules HMRC have used, then they will still need to declare against this calculation and follow the existing process to challenge the calculation. If a software vendor identifies what they feel could be a technical issue with the Tax calculation API, they will need to contact the SDS Team immediately.

Once a customer is happy with all the information, they will have to agree to a declaration and send it to HMRC.

 > **The Declaration**

> “Before you can submit the information displayed here in response to your notice to file from HM Revenue & Customs, you must read and agree the following statement by 

> [vendor to decide how you manage the actual declaration in the user interface for example a tick box, confirm button or other]

> The information I have provided is correct and complete to the best of my knowledge and belief
If you give false information you may have to pay financial penalties and face prosecution.”

Software must send the calculationId that matches the calculation the customer is declaring against with the declaration.


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
* when a business resubmits an update period, the software will have to use the trigger calculation endpoint and follow the same process as the submitting an update period process 
* software will have to resubmit any changes to the summary totals for income source. The nature of this obligation means there is no need to create separate update periods
* where a business resubmits an annual summary update, previous figures that have been submitted must be sent again as well as any additional information. A zero or null will overwrite previously provided information
* the software will have to use the [trigger calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#tax-calculations_trigger-a-tax-calculation_post_accordion) endpoint and follow the same process

Note: 

* any changes that are made before the customer has crystallised is not a formal amendment For all changes to annual summary updates including Self-employment, FHL property business and non-FHL property business:

### Key points for changing previously submitted updates

*	changes to Periodic updates - the update period you are trying to change must match the original update period exactly or it will be rejected
*	changes to Annual updates - all figures previously supplied must be provided again, a zero or a null will overwrite any previously submitted information.


## Make an amendment after crystallisation

If a customer wants to make any changes following crystallisation they have 12 months from the statutory filing date to do this (the statutory filing date is 31 January following the end of the tax year, or 3 months from receipt of a Notice to File by the taxpayer whichever is the later).

As with the current process the customer will make changes to the relevant information in software and resubmit the relevant periodic or annual updates, and follow the same process of triggering the calculation, they will not have to re-declare.

Note: any changes made following crystallisation will be a formal amendment under section 9ZA TMA 1970

## View liabilities and payments

The ability to view liabilities and payments is being developed and will be provided later. 


## Pay or get a repayment

Vendors should present messages to business users at key points in their journey that give them the option to make payments ahead of any obligation date to help spread the cost. We will deliver functionality that allows vendors to make users aware of payment dates.

There are multiple ways to make a payment for the Self Assessment regime, they can be found on GOV.UK at:

[https://www.gov.uk/pay-self-assessment-tax-bill](https://www.gov.uk/pay-self-assessment-tax-bill) 

Vendors should, in their messaging, ask customers to visit that link so the customer can make a payment in the method that suits them.

The contents of this GOV.UK page will be updated and subject to change.

For a business to view what previous payments it has made to HMRC, vendors should present messages at key points in their journey that encourage them to visit their Business Tax Account at:

[https://www.access.service.gov.uk/login/signin/creds](https://www.access.service.gov.uk/login/signin/creds)

Vendors in their messaging should ask customers to visit that link. 

Customers can pay their tax bill by direct debit, making it easy and convenient to pay.
HMRC is delivering functionality for customers to set up direct debit instructions to pay tax when it becomes due. Customers may also set up a regular payment plan to ensure funds are available when tax becomes due.
These services will be available when a customer first subscribes to HMRCs tax services, and at any time after a customer has been subscribed through their digital tax
account. Access to the services will be via the customer’s digital tax account at:

[https://www.access.service.gov.uk/login/signin/creds](https://www.access.service.gov.uk/login/signin/creds)

Vendors in their messaging should ask customers to visit that link.  

Customers will be able to view payments made to HMRC in software. 
Details will be updated here once they are available.

## Make a change of circumstances

Functionality within the Business Tax Account will allow businesses to update their ‘change of circumstances’, until then they should call the HMRC helpline about a change of circumstances.
When the online functionality is delivered, vendors should present messages to business users regularly to remind them to check and update their details with HMRC.
Business users will then be able to do that by visiting their Business Tax Account at:

[https://www.access.service.gov.uk/login/signin/creds](https://www.access.service.gov.uk/login/signin/creds)

Businesses will be able to update a range of information, including addresses, telephone numbers, e-mail and business type.

### Agent able to notify their own change of circumstances

This will initially be the usual process, which can be used to remove the agent reference number and Government Gateway (GGW) enrolment (HMRC-AS-AGENTS).
The scenario is needed where an agency firm ceases trading.
If an agent no longer wants to participate in MTD they can stop using their GGW ID.
An online interface is being developed as part of the wider change of circumstances solution.

## View Future obligations or previous returns in BTA

Some customers may wish to view information regarding their income tax for assurance purposes, this may also include any previous updates that have been submitted.

Vendors should make available within software products as many suitable features as possible to meet user needs.

Vendors can direct users to visit their [Business Tax Account](https://www.access.service.gov.uk/login/signin/creds) to view certain information.

A customer who has signed up for MTD and agreed to report using software, can choose to sign into their Business Tax Account and view information such as obligation periods, year-to-date and income tax calculations.
User research will continue, and further iterations will be made which will enhance the functionality of the Business Tax Account and help to improve user experience.

Future features will also enable customers to have a statement view, make a change of to their business information, along with links to make a card payments.

The Business Tax Account displays the following information:

* reporting obligations, and their status, per income source
* tax estimates
* year-to-date income tax calculation
