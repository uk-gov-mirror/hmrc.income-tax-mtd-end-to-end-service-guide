---
title: ITSA end-to-end service guide
weight: 1
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

# Income Tax Self Assessment end-to-end service guide

Version 1.4 issued 5 November 2020
***

This service guide is to help software designers and vendors understand how their software fits in with HMRC APIs.
It covers elements of the service delivered by HMRC to show how the Income Tax end-to-end service works.

Product owners, developers and business analysts can also use this guide to learn more about Making Tax Digital for Income Tax Self Assessment (ITSA).

## Overview

Making Tax Digital (MTD) for Income Tax is a service that will improve self-assessment for businesses and landlords that currently submit a tax return.

Similar to MTD for VAT, MTD for Income Tax requires businesses and landlords to keep their records digitally and to submit information about their business income to HMRC using MTD-compatible software.

The other major change is that businesses and landlords will no longer send an annual tax return. Instead, they will be required to send HMRC quarterly summary updates of their business income and expenditure as well as complete a process to finalise their overall tax position at the end of the year. 

Based on the information provided, they will receive a view of their emerging tax position, helping them to better budget for their tax throughout the year. There are no changes to payment dates.

Customers will be mandated to provide the following information through the software:

* income and expenses for each self-employment and property businesses at least every 3 months
* allowances and adjustments for each self-employment and property business at least once a year, at the end of the accounting period
* finalisation of business income sources with an End of Period Statement (EOPS)

HMRC expects software providers to offer customers the ability to finalise their overall tax position using the software. This process is sometimes called crystallisation.

In the future, partnerships will be required to provide the information mentioned above for the partnership. Individual partners will not be mandated to report their partner income quarterly.

HMRC will provide the APIs for the software to support all of the personal data items that need to be submitted under Self Assessment. Although these elements will not be mandated through the software, there will be market demand for software that enables any user to finalise the entirety of their tax affairs.

By developing a product now, you will support mandate of the service, influence its design and ensure you have a product ready for the millions of customers that will need MTD-compatible software.

## Software vendor overview

### Developer journey to production credentials

It is important that quality software products are available for customers to submit their self-assessment returns through Making Tax Digital. HMRC is committed to providing help and support for vendors and developers throughout the software development process.

Here, we describe the steps developers go through from initially registering an application to gaining production credentials to submitting live data and also the support available at each stage and the interactions developers will have with HMRC.

1.	Sign in to the [developer hub](https://developer.service.hmrc.gov.uk/api-documentation) and register your application for sandbox testing.
2.	Review the API documentation and Income Tax end-to-end service guide.
3.	Test ITSA endpoints and develop your software application, any queries during this phase should be sent to <SDSTeam@hmrc.gov.uk>.
4.	Register your application for production credentials by creating a production application within your developer hub account and completing the requested sections.
5.	Testing document is sent to the developer by email.
6.	Provide testing logs and credentials used for testing to HMRC.
7.	Developer testing is reviewed by HMRC (including fraud header validity).  If testing is satisfactory an email questionnaire and request for product demonstration are sent. Otherwise, further testing and development will be required for review.
8.	The software vendor demonstrates its software to HMRC over online screen sharing.
9.	Production credentials are issued if all requirements are met or further development is required and a new demonstration needs to be organised.
10.	Software is listed on GOV.UK after going through the HMRC recognition process.

## Production approvals process for Making Tax Digital for Income Tax Self Assessment

Our key objectives for MTD for Income Tax are to:

* ensure customers have a streamlined end to end journey whereby, as far as is possible, software supports everything a business customer needs to do to meet their Income Tax obligations
* safeguard customer data and protect HMRC systems against fraud and criminal attack

This section of the guide explains which things your product must always include before production credentials are sought and also describes things you should consider building into your products.


### Minimum functionality standards

The production approvals process will include an assessment of whether a product includes certain minimum functionality. In order to be granted production credentials for an MTD for Income Tax product, a software product must:

* capture and submit fraud prevention header data to the specifications required by law
* include functionality that enables

** Commented [WJ(T2]: Editors to add hyperlink here to where we discuss ‘fraud prevention headers’ further down **

1.	The creation and maintenance of all business records a customer is required by law to keep and maintain in digital form
2.	Submission of quarterly update information for each business income	 source (Self-employment, Multiple self-employments, UK Property Income)
3.	Customers to have the option to report data using the ‘Annual API’ at any time
4.	Submission of an End of Period Statement for each business income source (with declaration of completeness)
5.	Customers to call for and view an estimate of their Income Tax liability for each tax year at any time
6.	Customers to make a self-assessment of the tax and Class 4 NIC due on their total taxable income and a final declaration of completeness and correctness (‘Crystallisation’) no later than 31 January following the end of tax year in which that income is taxable
7.	Losses and adjustments allowing the customer to carry forward or set sideways (when permitted) business losses occurring in any one year as well as to apply losses incurred in earlier years against current year profits
8.	Customers to pay voluntary Class 2 National Insurance contributions should they wish to.

The Making Tax Digital for Income Tax APIs that include the endpoints for the functionality described in points 1 to 8 above are:

1.	Self assessment
2.	Individual losses

** Commented [RT6]: Justine can you please add the relevant endpoints please **


## Fraud Prevention Headers

Transaction Monitoring is a key security approach adopted in the UK and globally.

Supplying fraud prevention header information for all our APIs is mandatory. Therefore, it is essential that they are included in your products now before approval can be granted, and production credentials issued. HMRC must see evidence of fraud prevention headers being sent and be satisfied as to their level of accuracy.

The developer must test their fraud headers to derive the correct values and provide SDST with a screenshot of the response received from the Test Fraud Header API. [Guidance on Fraud Prevention Headers](https://developer.service.hmrc.gov.uk/guides/fraud-prevention/) is available.



### Testing requirements

The following endpoints are required to be tested to cover the self-employment reporting:

1.	‘Create a test user which is an organisation’ to create test data.
2.	‘Add a self-employment business’ endpoint to create an MTD
subscription for an individual within the sandbox environment.
3.	‘Retrieve self-employment business obligations’ to return obligation
periods (this will return a canned response the sandbox).
4.	‘Create a self-employment periodic update’ to make a submission.
5.	‘Amend a self-employment periodic update’ to amend a submission
already made.
6.	‘Amend a self-employment annual summary’ to create or amend annual
summary information.
7.	‘Trigger a calculation’ to request a calculation.
8.	‘Retrieve a calculation’ to return the calculation liability (this will return a canned response from the sandbox).


** NUMBERING HAS CHANGED BELOW -- IS THIS CORRECT? **

The following endpoints are to be tested to cover EOPS (End of Period Statement) and Crystallisation:

9.	‘Submit self-employment End of Period Statement’ to finalise your self- employment income. (Developers must also build the facility for a user to make a declaration of correctness and completeness in relation to the EOPS)
10.	‘Retrieve End of Period Statement Obligations for a Self-Employment Business’ to check if an EOPS obligation has been fulfilled, this will return a canned response in the sandbox.
11.	‘Intent to crystallise’ to return the tax Calculation ID for crystallisation. 12.‘Retrieve a calculation’ with the tax Calculation ID for crystallisation, to return the calculation liability. This will return a canned response in the
sandbox.
13.	‘Crystallisation’ to finalise the tax liability. (Developers must also build the facility for a user to make a declaration of correctness and completeness when crystallising.)

Once the testing is complete, send details of the dummy NINO (National Insurance Number) used to call the above endpoints in the sandbox to the SDS team at <SDSTeam@hmrc.gsi.gov.uk>.

You will need to contact us within 2 weeks of completing your API testing to enable us to view the data within our logs. It takes 10 working days to advise of the outcome. If the testing is satisfactory a product demonstration will be arranged.
Developers need to consider the following:

* build functionality to allow business customers to report income from non-business sources
* consider the one-hour delay as part of the software workflow to update the status of obligations
* consider a 5 second delay before retrieving the calculation
* consider developing guidelines within the software for relevant users, including a reference to HMRC user interface journeys for individuals and agents
* use APIs as efficiently as possible to prevent hitting the rate limit
* build relevant error responses so that the software can deal with exceptions
* when authorising software, the correct MTD gateway credentials or agent services credentials, need to be used when logging into the system
* consider providing notifications to customers when periodic submissions are due




#### Example workflows for self-employment

** NUMBERING HAS CHANGED FIX NUMBERING **

Example workflows for self-employment

14.	Create an update.
a. List all self-employment businesses.
b. Create a self-employment periodic update.
c. Trigger a tax calculation - can be triggered anytime but must be triggered at the end of the quarter to meet the obligation.
15. Amend an update.
a. List all self-employment update periods.
b. Amend a self-employment periodic update.
 
16.	End of Period Statement.
a. Get a self-employment annual summary.
b. Amend a self-employment annual summary.
c. Get self-employment Business Income Summary Source (BISS).
d. Retrieve end of period statement obligations for a self-employment business.
e. Agree with the declaration within the software.
f. Submit self-employment end of period statement.

17.	Crystallisation.
a. Intent to crystallise.
b. Retrieve a tax calculation - to view the current calculation.
c. Agree with the declaration within the software.
d. Crystallisation - agree on the final calculation


### Product Demonstration

The product demonstration is the final part of the process after all preceding steps have been completed. Make sure you have completed the <a href="documentation/mtd-itsa-sa-demo-checklist-self-serve.docx" download>pre-demo checklist</a> before the demonstration.

At the product demonstration HMRC expects to see a consumer-ready product and see software go through the following process flows:

1. New customer registers with the software and sets up an account.
2. Customer authorises software (OAuth 2.0 journey).
3. Customer views obligations and his or her status.
4. Customer digitally imports data into the appropriate periodic update and submits information.
5. Software triggers a calculation and replays to customer.
6. End of Period Statement (EOPs) and declaration.
7. Customer crystallisation - the appropriate display of the tax calculation, declarations, and error messages.

## Terms of use

You must comply with our [terms of use](https://developer.service.hmrc.gov.uk/api-documentation/docs/terms-of-use). You must accept the terms of use before we can issue you with production credentials.


## Software choices

HMRC publishes a [list of compatible software](https://www.gov.uk/government/publications/making-tax-digital-software-suppliers-terms-of-collaboration/terms-of-collaboration-between-hm-revenue-and-customs-and-software-developers#Annex-C) for Making Tax Digital for Income Tax on GOV.UK. Software vendors will be added to this list when they have completed the necessary steps in the ‘Software vendor overview’ section.  

From our experience with MTD VAT, businesses, agents and third parties will use this as the definitive list of MTD compatible software. All software listed on the GOV.UK page must allow the user to submit a summary of business or property information up to and including the End of Period Statement, and also offer users the ability to finalise their tax affairs using the software. The current GOV.UK page will be developed over time to meet user needs, including filters that help users to find software.

HMRC expects demand for products that serve all of the requirements of MTD, including keeping the required digital records for business or property income and the ability to submit all relevant non-business information to HMRC.

### Free-to-use software

The government has committed to the availability of free software for small businesses mandated to use MTD for income tax. HMRC strongly encourages all developers to consider producing a free version of their MTD for Income Tax product for this customer group. 

By ‘small businesses’ we mean that eligibility for free software will apply where the business meets all of these conditions:

* it is unincorporated (for example self-employed persons or landlords) 
* it has turnover within the scope of Income Tax below £85,000 
* it has no employees 
* it uses cash basis accounting 

For the avoidance of any doubt, there is no expectation that a free product will include VAT, Corporation Tax or PAYE functionality. 

In addition to the minimum standards set out in the terms of use, and the general functionality standards applicable to all MTD for Income Tax software, we expect any free software product you provide to small businesses to:

* enable the provision of a dataset that correlates to the current [SA103S (self-employment supplementary page) (short) (2020 version](https://www.gov.uk/government/uploads/system/uploads/attachment_data/file/604987/sa103s-2017.pdf)
* enable the provision of a dataset that correlates to the current [SA105 UK property pages (2019-20 version)](https://www.gov.uk/government/uploads/system/uploads/attachment_data/file/604310/sa105-2017.pdf) where the number of properties does not exceed one
* provide a reasonable level of guidance, help and support to users (HMRC is open to views on what might be ‘reasonable’ for a free product and will publish further advice on this in due course)
* allow the end user to own and have access to all their records created using the software product (past and present) to enable them to retrieve data and promptly export it if necessary
* be free for the business to use to comply with their MTD for Income Tax obligations for a full annual accounting period on the understanding the business continues to meet the eligibility criteria below

HMRC would not require free software to link or integrate with an Agent product.


## End-to-end user journey

These journeys show examples of use:

* [Income Tax Self Assessment (ITSA) set up activities](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/setup.html)
* [retrieving obligations](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#receive-obligations) 
* [submitting periodic updates for Self Employment and property businesses](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#submit-periodic-updates-for-self-employment-and-property-businesses)
* [submitting annual updates for Self Employment and property businesses](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#submit-annual-updates-for-se-and-property-businesses)
* [retrieving a tax calculations](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#retrieve-a-tax-calculation)
* [making changes to previously submitted data](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#make-changes-to-previously-submitted-data)
* [finalising business income End of Period Statement (EOPS)](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/businessandpropertyincome.html#finalise-business-income-end-of-period-statement-eops)
* [providing information about how to treat a loss](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/final-return-crystallisation.html#provide-information-about-how-to-treat-a-loss)
* [crystallisation](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/final-return-crystallisation.html#crystallisation)
* [ITSA (MTD) close down activities](https://developer.service.hmrc.gov.uk/guides/income-tax-mtd-end-to-end-service-guide/documentation/closedown.html)

## Related API documentation
<!--- Section owner: MTD Programme --->
* [Create Test User API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/api-platform-test-user/1.0)
* [Test Fraud Prevention Headers API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/txm-fph-validator-api/1.0)
* [Agent Authorisation REST API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/agent-authorisation-api/1.0)

## Changelog

Version 1.1

* Payments and Liabilities section added.

Version 1.2

* Multiple businesses section added.
* Construction Industry Scheme (CIS) section added.

Version 1.3

* Losses updated.
* Additional income section added.

Version 1.4

* Construction Industry Scheme (CIS) section updated.

