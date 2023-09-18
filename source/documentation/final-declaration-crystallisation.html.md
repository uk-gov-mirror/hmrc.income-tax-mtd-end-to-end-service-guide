---
title: Final Declaration (Crystallisation)
weight: 4
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Final Declaration (Crystallisation)
**Note: The term 'final declaration' is now used instead of the term 'crystallisation'. Endpoints with 'crystallisation' or 'crystallise' in their names will continue to be used until further notice.**

Final declaration is the process that allows customers to finalise their tax position for any one tax year, taking into account all sources of chargeable income and gains, whether business income or otherwise. 

It is also the process by which most formal claims for reliefs and allowances and any deductions are made, where these were previously included within a Self Assessment tax return.

Customers are able to tell us at this point (subject to the existing limits) how they wish any losses available to them to be treated.

Customers can make a final declaration from 6 April Year 1. The deadline for final declaration is 31 January Year 2. The software should remind customers to help them to meet this deadline.

Before starting the final declaration journey, the software package must ensure that for the relevant tax year, the customer:

* has submitted quarterly update information for each business income source (self-employment and property income)
* has finalised EOPS for all their businesses (self-employment and property income)
* has already provided their entire income (for example, interest, dividends, other SA schedules)
* does not have any additional information to provide (for example, information about how to treat a loss)

If your software will not allow customers to report their entire income and reliefs, customers should be informed to report them using HMRC Online Services.

## Making a final declaration

The software will have to let HMRC know that the customer is ready to submit a final declaration. To do this, you must call the [Trigger a Self Assessment Tax Calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D/post) endpoint under the [Individual Calculations (MTD) API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api) with the ```finalDeclaration``` parameter set to true. This has the following consequences: 

* it starts the final declaration process in HMRC 
* it triggers the business validation rules (which, if violated, produce errors rather than warnings) 
* it generates a final liability calculation and a ```calculationId```
* the software must then quote the ```calculationId```when retrieving the calculation output using the [Retrieve A Self Assessment Tax Calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D~1%7BcalculationId%7D/get) endpoint

### Calculations that produce errors

We suggest that you first check there are no validation errors by retrieving the self-assessment metadata using the [Retrieve A Self Assessment Tax Calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D~1%7BcalculationId%7D/get) endpoint. Validation comprises different types of data integrity and data quality checks applied to information submitted by third-party applications that encompass both technical (schema) and business (complete and meaningful data) considerations.

If there are validation errors when you trigger the calculation, no calculation results are generated. For example, it is possible that errors in previously submitted income data can prevent a calculation from being performed. 

To prevent the validation errors from being generated, the customer must go back and amend the digital records. The software should resubmit the revised summary totals for the relevant periods, and should then call the [Trigger a Self Assessment Tax Calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D/post) endpoint again.

### Calculations that are free from errors

If the [Trigger a Self Assessment Tax Calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D/post) results in no errors, the results of the final declaration calculation are available. 

The calculation output provides a summary of each income source (for example self-employment, UK property, foreign property and UK bank and building society interest), plus a breakdown of allowances and reliefs applied, and a breakdown of the Income Tax and NIC payable - broadly the equivalent of the current SA302. This calculation output will also include additional income submitted by the customer in the ITSA submission service.

If a customer thinks the calculation is incorrect based on the data they have submitted, they can go back and change the information, by resubmitting the relevant update with the correct information. Once they have done this, the software will have to call the [Trigger a Self Assessment Tax Calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D/post) endpoint again to generate a new final liability.

If a customer does not agree with the calculation based on rules HMRC have used, then they will need to contact HMRC before submitting their final declaration. If a software vendor identifies what they feel could be a technical issue with the [Individual Calculations API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api), they will need to contact the SDS Team immediately.

If a customer thinks the calculation is correct, then they can go ahead and submit their final declaration through the [Submit a Self Assessment Final Declaration](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Final-Declaration/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D~1%7BcalculationId%7D~1final-declaration/post) endpoint. It is important to note that once a customer has submitted their final declaration, they will not be able to amend their submission using their software.

### Agreeing to the declaration

Once a customer is confident that they have submitted all the required income tax information through software and HMRC online services, they will have to agree to a declaration and send it to HMRC. When using the software, this is done through the [Submit a Self Assessment Final Declaration](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Final-Declaration/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D~1%7BcalculationId%7D~1final-declaration/post) endpoint.

 > **The Declaration**

> “Before you can submit the information displayed here in response to your notice to file from HM Revenue & Customs, you must read and agree to the following statement by

> [Here the vendor can decide how to manage the actual declaration in the user interface, for example a tick box, confirm button or other method]

> I declare that the information and self-assessment I have filed are (taken together) correct and complete to the best of my knowledge. I understand that I may have to pay financial penalties and face prosecution if I give false information.”

> **Declaration for Agents**

 > "I confirm that my client has received a copy of all the information being filed and approved the information as being correct and complete to the best of their knowledge and belief. My client understands that they may have to pay financial penalties and face prosecution if they give false information."

The software must send the ```calculationId``` that matches the specific calculation that the customer is agreeing to in the declaration.

## Final declaration user journey

<a href="figures/crystallisation-diagram.svg" target="blank"><img src="figures/crystallisation-diagram.svg" alt="crystallisation process API diagram" style="width:720px;" /></a>

<a href="figures/crystallisation-diagram.svg" target="blank">Open the final declaration process diagram in a new tab</a>.

1.	The customer is ready to complete their final declaration.
2.	The software calls the [Trigger a Self Assessment Tax Calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D/post) endpoint with ```finalDeclaration``` as true.
3.	HMRC receives the request, starts the tax calculation, and returns a Calculation ID.
4.	The software receives the ```calculationId```.
5.	HMRC generates the final declaration tax calculation - this process will also convert any business validation warnings into errors. If there are any errors, the calculation will not run and the customer will not be able to declare the liability.
6.	HMRC Stores the tax calculation with ```calculationId```.
7.	The software uses the ```calculationId``` to receive details of the calculation or errors using the [Retrieve A Self Assessment Tax Calculation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Tax-Calculations/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D~1%7BcalculationId%7D/get) endpoint.
8.	HMRC provides the calculation results in case of a successful call. If there are any validation errors, the customer will not be able to view the calculation results.
9.	The software must make the calculation results available to the customer – at this point in the journey, it is mandatory that the customer is shown a copy of the calculation associated with ```calculationId```. As a minimum, a customer must view the equivalent of what is currently in the SA302.
10.	The customer reviews the calculation and the declaration text.
11.	The customer confirms the declaration and the software calls the [Submit a Self Assessment Final Declaration](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api/4.0/oas/page#tag/Final-Declaration/paths/~1individuals~1calculations~1%7Bnino%7D~1self-assessment~1%7BtaxYear%7D~1%7BcalculationId%7D~1final-declaration/post) endpoint using the Calculation ID to confirm the calculation to which the customer is agreeing.
12.	HMRC receives the submission, marks the obligation as fulfilled, and confirms receipt with a success code.
13.	The software receives a success code (HTTP 204) and the software needs to confirm to the customer that HMRC has received the return because HMRC will not communicate this to the customer.
14.	The customer views confirmation that the return has been successfully submitted to HMRC.

## Making an amendment after final declaration

If a customer wants to make any changes following a final declaration, they have 12 months from the statutory filing date to do this (the statutory filing date is 31 January following the end of the tax year). They can make these changes by following the existing [Self Assessment tax returns amendment process](https://www.gov.uk/self-assessment-tax-returns/corrections). These amendments cannot be made using software.

**Note:** Any changes made following final declaration will be a formal amendment under section 9ZA TMA 1970.

## Pay or get a repayment

Vendors should present messages to business users at key points in their user journey that gives them the option to make payments ahead of any obligation date to help spread the cost. We will deliver functionality that allows vendors to make users aware of payment dates but the payment itself cannot be made through software.

There are multiple ways to make a payment for Self Assessment which can be found on GOV.UK at:

[https://www.gov.uk/pay-self-assessment-tax-bill](https://www.gov.uk/pay-self-assessment-tax-bill)

Vendors should, in their messaging, ask customers to visit that link so the customer can make a payment in the method that suits them.

The contents of this GOV.UK page will be updated and subject to change.

For a business to view the previous payments it has made to HMRC, vendors should present messages at key points in their journey that encourage them to visit their HMRC Online Services account at:

[https://www.access.service.gov.uk/login/signin/creds](https://www.access.service.gov.uk/login/signin/creds)

Vendors in their messaging should ask customers to visit that link.

Customers can pay their tax bills by direct debit, making it easy and convenient to pay.
HMRC is delivering functionality for customers to set up direct debit instructions to pay tax when it becomes due. Customers may also set up a regular payment plan to ensure funds are available when tax becomes due.
These services will be available when a customer first subscribes to HMRCs tax services, and at any time after a customer has been subscribed through their digital tax
account. Access to the services will be via the customer’s digital tax account at:

[https://www.access.service.gov.uk/login/signin/creds](https://www.access.service.gov.uk/login/signin/creds)

Vendors in their messaging should ask customers to visit that link.  

Customers will be able to view payments made to HMRC in the software. Details will be updated here once they are available.
