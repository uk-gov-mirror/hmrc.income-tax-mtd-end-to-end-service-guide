---
title: Final return (crystallisation)
weight: 4
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Final return (crystallisation)

This is the process that allows the customer to finalise their tax position for any one tax year, taking into account all sources of chargeable income and gains, whether business income or otherwise. In other words, this process brings together all the data that a taxpayer needs to provide to HMRC to reach their final tax liability for a specific year.

It is also the process by which most formal claims for reliefs and allowances and any deductions will be made, where these were previously included within a Self Assessment tax return.

Customers will also be able to tell us at this point (subject to the existing limits) how they wish any losses available to them to be treated.

Customers can crystallise from 6 April Year 1. The deadline for Crystallisation is 31 January Year 2. The software should remind customers to help them to meet this deadline.

## Provide information about how to treat a loss

### Losses and Claims

A self-employed business can make a loss when the trade expenses are more than the trade income.
If the business made a loss for a year prior to signing up to Making Tax Digital, the customer or agent will need to submit details of the loss to be brought forward.

<a href="figures/losses-api-diagram.svg" target="blank"><img src="figures/losses-api-diagram.svg" alt="Losses API calls" style="width:720px;" /></a>

<a href="figures/losses-api-diagram.svg" target="blank">Open the Losses diagram in a new tab</a>.

Vendors can use the [create a brought forward losses](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#brought-forward-losses_create-a-brought-forward-loss_post_accordion) endpoint to enable customers to submit the brought forward loss to HMRC.

When the loss detail has been submitted, or if a loss arises for a tax year following sign up to Making Tax Digital, a claim will need to be made to either:

* utilise the loss against an income source for a specific year, or 
* claim to carry the loss forward so that it is available to use in later years

The [Loss claims](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims) endpoint allows the user to:

* [provide a list of Loss claims](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_list-loss-claims-test-only_get_accordion)
* [create a Loss claim against an income source for a specific tax year](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_create-a-loss-claim-test-only_post_accordion)
* [show the detail of an existing Loss claim](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_retrieve-a-loss-claim-test-only_get_accordion)
* [delete a previously entered Loss claim](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_delete-a-loss-claim-test-only_delete_accordion)
* [update a previously entered Loss claim](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-losses-api/1.0#loss-claims_amend-a-loss-claim-test-only_post_accordion)

To carry-back a loss, the customer should contact HMRC who will be able to apply this manually.

## Submit information about personal income
### Self Assessment return

The software should prompt customers to make sure they have considered the following potential additional income sources (links to the APIs where the functionality has been provided, we will continue to release additional functionality and will update this document when relevant) 

* any income from bank/building society interest (supported in live) - LINK TO ENDPOINT
* any income from dividends (supported in live)  - LINK TO ENDPOINT
*	any gift aid contributions they have made (supported in live)  - LINK TO ENDPOINT
*	any pension contributions 
*	any pension income
*	capital gains
*	income from employment
*	additional information (currently provided on the SA101)
*	any income from partnerships
*	any income from trusts 
*	any Foreign income

Note: 

Information currently provided through the existing Self Assessment process: if a customer needs to report information to HMRC that is not yet supported under MTD or your software, they will need to complete a Self Assessment tax return.  Any information they have provided through MTD will not be considered and they will have to submit everything through the existing HMRC Self Assessment service.

## Crystallisation 

The software will have to let HMRC know that the customer is ready to crystallise, to do this you must call the [intent to crystallise](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#crystallisation_intent-to-crystallise_post_accordion) endpoint. This will start the crystallisation process in HMRC. It will trigger the business validation rules (which will become errors rather than warnings) and generate a final liability calculation.

The intent to crystallise response includes a calculationId the same as the trigger calculation endpoint. The software will then have to retrieve the calculation using the ‘calculationId’ to retrieve a tax calculation endpoint to get the calculation output.

A crystallisation calculation is performed if the calculation was triggered by the intent to crystallise endpoint under the Self Assessment (MTD) API.

The Calculation ID output provides a summary of each income source (for example self-employment, UK Property, UK bank and building society interest), plus a breakdown of allowances and reliefs applied, and a breakdown of the income tax and NIC payable - broadly the equivalent of the current SA302.

For a crystallisation calculation the minimum number of endpoints that need to be called are:

* [retrieve self assessment tax calculation metadata](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-metadata-test-only_get_accordion)
* [retrieve self assessment tax calculation taxable income](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-taxable-income-test-only_get_accordion)
* [retrieve self assessment tax calculation income tax NICs calculated](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-income-tax-and-nics-calculated-test-only_get_accordion)
* [retrieve self assessment tax calculation allowances, deductions and reliefs](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-allowances-deductions-and-reliefs-test-only_get_accordion) (if applicable)
* [retrieve self assessment tax calculation messages](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-messages-test-only_get_accordion) (if applicable)

A crystallisation Calculation ID will not always have a calculation result. It is possible that errors in previously submitted income data could prevent a calculation from being performed.

The existing paper-based SA302 form fields span the following endpoints in the new [Individual Calculations API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-allowances-deductions-and-reliefs-test-only_get_accordion):

* [retrieve self-assessment tax calculation taxable income](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-taxable-income-test-only_get_accordion)
* [retrieve self-assessment tax calculation Income Tax NICs calculated](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-income-tax-and-nics-calculated-test-only_get_accordion)
* [retrieve self-assessment tax calculation allowances, deductions and reliefs](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-allowances-deductions-and-reliefs-test-only_get_accordion)

If calculation errors are present, these errors can be returned to the customer by the [retrieve self assessment tax calculation messages](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/1.0#self-assessment_retrieve-self-assessment-tax-calculation-messages-test-only_get_accordion) endpoint.

Once the software has called the [intent to crystallise](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#crystallisation_intent-to-crystallise_post_accordion) endpoint, this will trigger a final liability calculation and software will receive a Calculation ID.

<a href="figures/crystallisation-diagram.svg" target="blank"><img src="figures/crystallisation-diagram.svg" alt="crystallisation process API diagram" style="width:720px;" /></a>

<a href="figures/crystallisation-diagram.svg" target="blank">Open the crystallisation process diagram in a new tab</a>.

1.	Customer is ready to complete their final tax return. 
2.	The software calls the intent to crystallise endpoint – this endpoint triggers the creation of the crystallisation calculation for the customer to agree. 
3.	HMRC receives the request and starts the tax calculation and returns Calculation ID. 
4.	The software receives the 'calculationId'.
5.	Generates the crystallisation tax calculation - this process will also convert any business validation warnings into errors, if there are any errors the calculation will not run and the customer will not be able to crystallise the liability.
6.	HMRC Stores tax calculation with calculationId.
7.	The software uses the Individuals Tax Calculation API to call the relevant endpoints, the minimum number of endpoints that need to be called are: </br>
a) retrieve self assessment tax calculation metadata </br>
b) retrieve self assessment tax calculation taxable income</br>
c) retrieve self assessment tax calculation income tax NICs calculated</br>
d) retrieve self assessment tax calculation allowances, deductions and reliefs (if applicable)</br>
e) retrieve self assessment tax calculation messages</br>

We suggest that you retrieve the self-assessment metadata first to check there are no validation errors.  If there are errors the calculation will not have been generated. The customer must go back and amend the digital records, software should resubmit the revised summary totals for the relevant periods, then call the intent to crystallise endpoint again. 

8.	HMRC provides the calculation response. 
9.	Software surfaces the calculation to the customer – at this point in the journey, it is mandatory that the customer is shown a copy of the calculation resulting from the intent to crystallise calculationId. As a minimum a customer must view the equivalent of what is currently in the SA302, to do that the following endpoints MUST be called: </br>
a) retrieve self assessment tax calculation taxable income</br>
b) retrieve self assessment tax calculation income tax NICs calculated</br>
c) retrieve self assessment tax calculation allowances, deductions and reliefs</br>
10.	Customer reviews the calculation and declaration text. 
11.	Customer confirms declaration and software calls the crystallisation endpoint using the crystallisation calculation ID to confirm the calculation the customer is agreeing. 
12.	HMRC receives the submission, confirms receipt with a success message and marks the obligation as fulfilled.
13.	The software receives a success message and confirms that HMRC has received the return.
14.	Customer views confirmation that return has been successfully submitted to HMRC.

The software must use the intent to crystallise 'calculationId' to retrieve the final calculation and display that calculation to the customer. The customer must review this calculation and confirm it is complete and correct by sending the declaration.

If the customer thinks the calculation is incorrect as a result of data they have submitted, they can go back and change the information, by resubmitting the relevant update with the correct information. Once they have done this the software will have to call the [intent to crystallise](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0#crystallisation_intent-to-crystallise_post_accordion) endpoint again to generate a new final liability.

If the customer does not agree with the calculation based on rules HMRC have used, then they will still need to declare against this calculation and follow the existing process to challenge the calculation. If a software vendor identifies what they feel could be a technical issue with the Tax calculation API, they will need to contact the SDS Team immediately.

Once a customer is happy with all the information, they will have to agree to a declaration and send it to HMRC.

 > **The Declaration**

> “Before you can submit the information displayed here in response to your notice to file from HM Revenue & Customs, you must read and agree the following statement by 

> [vendor to decide how you manage the actual declaration in the user interface for example a tick box, confirm button or other]

> The information I have provided is correct and complete to the best of my knowledge and belief
If you give false information you may have to pay financial penalties and face prosecution.”

The software must send the ‘calculationId’ that matches the calculation the customer is declaring against with the declaration.

## Making an amendment after crystallisation

If a customer wants to make any changes following crystallisation they have 12 months from the statutory filing date to do this (the statutory filing date is 31 January following the end of the tax year, or 3 months from receipt of a Notice to File by the taxpayer whichever is the later).

Note: any changes made following crystallisation will be a formal amendment under section 9ZA TMA 1970

[GINAS COMMENT This needs to go with the EOPS section. You may need to tinker with the diagram to align with this as I am not 100% confident on the journey]

### Annual accounting adjustments

Within the annual Self Assessment process, annual accounting adjustments are applied to income and expenses before the business or agent submits their tax return to HMRC. Within Making Tax Digital as the income and expenses are submitted to HMRC at least quarterly
during the active accounting period, this means a new process to accommodate these adjustments were required.

### Submitting annual accounting adjustments

After an accounting period has ended a business or agent may need to submit accounting adjustments to the income and expenses that have been submitted throughout the year.

Endpoints to call are:

1. Trigger a Business source adjustable summary.
2. Retrieve a Self-employment business source adjustable summary (BSAS) or Retrieve a UK property business
source adjustable summary - this endpoint provides the totals of all income and expenses submitted for that business that can have adjustments applied to them.
3. Apply the adjustments as appropriate to the total figures returned via the Retrieve BSAS endpoint
4. Submit accounting adjustments self-employment or submit accounting adjustments UK property

Once submitted, if a further amendment is required to use the Retrieve self-employment accounting adjustments or Retrieve UK property adjustments endpoints to retrieve the previously submitted data and then repeat steps 3 and 4.


## View liabilities and payments

The ability to view liabilities and payments is being developed and will be provided later. 

## Pay or get a repayment

Vendors should present messages to business users at key points in their journey that give them the option to make payments ahead of any obligation date to help spread the cost. We will deliver functionality that allows vendors to make users aware of payment dates.

There are multiple ways to make a payment for Self Assessment which can be found on GOV.UK at:

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
