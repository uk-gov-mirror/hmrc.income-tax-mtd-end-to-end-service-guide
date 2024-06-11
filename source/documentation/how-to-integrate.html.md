---
title: How to integrate with HMRC APIs | Income Tax (Making Tax Digital) end-to-end service guide
weight: 2
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

# How to integrate with HMRC APIs

## Minimum Functionality Standards for MTD Software

For the customer to complete the end-to-end journey, we expect MTD for Income Tax compatible software products to facilitate the entire journey either in a single product covering the below requirements or through a number of products collectively meeting the below functionalities:

- provide HMRC with Transaction Monitoring Fraud Prevention Header data
- obtain business ID unique to each of the customer’s businesses
- create and maintain all digital records (or digitally link to a product that can do so) that a customer is required to keep by law in digital form - as per the [terms of use](/api-documentation/docs/terms-of-use) end users should own and have access to all their records created and be able to export these records if necessary
- submit quarterly update information for each mandated business income source (self-employment, multiple self-employments, UK property income and foreign property income)
- allow customers to view an estimate of their income tax liability by either signposting them to their HMRC account or by displaying it in software - if the latter, the estimate must be presented with a disclaimer as to its accuracy 
- make adjustments and finalise business income for the year (unless the product only supports the cash basis)
- carry forward or set sideways (when permitted) business losses occurring in any one year as well as to apply losses incurred in earlier years against current year profits
- submit final declaration or divert a customer into a channel where they can submit it
- divert customers into a different service for any non-mandated income sources which are not supported within the software to be declared

The Making Tax Digital for Income Tax APIs that include the endpoints for the functionality described above are:

- [Business Details](/api-documentation/docs/api/service/business-details-api/)
- [Business Source Adjustable Summary](/api-documentation/docs/api/service/self-assessment-bsas-api)
- [Individual Calculations](/api-documentation/docs/api/service/individual-calculations-api)
- [Individual Losses](/api-documentation/docs/api/service/individual-losses-api)
- [Obligations](/api-documentation/docs/api/service/obligations-api/)
- [Property Business](/api-documentation/docs/api/service/property-business-api/) (only for property full product)
- [Self-Employment Business](/api-documentation/docs/api/service/self-employment-business-api/) (only for self-employment full product)

### Additional Functionality

HMRC will be providing tailored feedback messaging, via nudges and prompts, that developers can incorporate into their software to support customers with their tax affairs. This is known as HMRC Assist. This service is preparing for a design and testing phase from July 2024. We encourage developers to build meaningful prompts and nudges into their software products to support the customer journey and drive compliant behaviours.

In addition, developers may wish to offer other functionality over and above the minimum standards. This could include automated functionality – for example automated quarterly updates. Where this is the case, customers remain legally responsible for meeting their quarterly obligations, and HMRC would expect appropriate safeguards to be built in.

### Free-to-use software

The government has committed to the availability of free software products for the smallest businesses with simplest affairs mandated to use MTD for Income Tax. HMRC strongly encourages all developers to produce a free version of their MTD for Income Tax product.

In addition to meeting the minimum functionality standards set out in this guide we expect any free software product you provide to businesses with the simplest tax affairs to: 

- have a reasonable level of guidance
- have help and support to users
- be free for the business to use to comply with their MTD for Income Tax obligations for a full annual accounting period 

There is no expectation that a free product will include VAT, Corporation Tax or PAYE functionality.

HMRC would not require free software to link or integrate with an Agent product. However, free software could be used in conjunction with wider compatible software products if necessary.

## Process for being granted Production access

### Fraud Prevention Headers

It is a legal requirement for software to supply compliant fraud prevention header information for all ITSA MTD APIs. This requirement must be met before Production access to ITSA MTD APIs can be granted. 

HMRC must see evidence of software sending fraud prevention headers and be satisfied as to their level of accuracy.

Before you start developing your MTD product we recommend you check that your technology stack supports the collection of all header data required.

[Guidance on Fraud Prevention Headers (HMRC Developer Hub)](/guides/fraud-prevention/) is available.

### Terms of use

If you are creating a new production application, you must comply with our [terms of use](/api-documentation/docs/terms-of-use). You must accept the terms of use to our satisfaction before we can issue you with production credentials. 

### Overview of developer journey to production credentials

1. Sign in to the  [developer hub](/api-documentation)  and register your application for sandbox testing.
2. [Create a test user which is an individual](/api-documentation/docs/api/service/api-platform-test-user/1.0/oas/page#tag/create-test-user/operation/Createatestuserwhichisanindividual) to create test data.
3. Review the [API documentation](/api-documentation/docs/api?filter=income-tax-mtd) and Income Tax end-to-end service guide (this document).
4. Develop your software application. Any queries during this phase should be sent to [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk).
5. Register your application for production credentials by creating a production application within your developer hub account. Or, if you already have an existing production application, you should add the relevant ITSA MTD API subscriptions to it.
6. Test software in Sandbox and provide credentials used for testing to HMRC.
7. Complete and return the Production Approvals Checklist issued to you by HMRC. 
8. HMRC review developer testing (including fraud header validity) and completed Production Approvals Checklist:
    - if satisfactory, you will be granted production access to the requested APIs
    - if not satisfactory, HMRC will contact you to advise what action is required

### Product build

#### Full End to End MTD Product

Developers have the option to either build all elements required to meet [minimum functionality standards (MFS)](#minimum-functionality-standards-for-mtd-software) in one go or to build these elements iteratively. If you choose to build iteratively, you are required to test the relevant APIs and complete the Production Approvals checklist for the appropriate stage of the build.

For a full end-to-end product there are two distinct stages and the APIs required for each are:

**1.** In year functionality (submitting periodic updates).

- Business Details (MTD)
- Obligations (MTD)
- Self-Employment Business (MTD) and/or Property Business (MTD) 
-  Individual Calculations (MTD) – if displaying calculation in software and not signposting customers to their HMRC account 

**2.** End of year functionality

- Self-Employment Business (MTD) and/or Property Business (MTD) – if including Annual Submission endpoints in end of year build 
- Business Source Adjustable Summary (MTD) – Not required for cash basis only products.
- Individual Losses (MTD)
- Obligations (MTD) – if supporting Final Declaration
- Individual Calculations (MTD) - if supporting Final Declaration in software and **not** diverting customers into a channel where they can submit it.

#### In-Year MTD Product 

The APIs required are:

- Business Details (MTD)
- Obligations (MTD)
- Self-Employment Business (MTD) and/or Property Business (MTD) 
- Individual Calculations (MTD) – if displaying calculation in software and not signposting customers to their HMRC account 

#### End of Year MTD Product

The APIs required are:

- Business Details (MTD)
- Self-Employment Business (MTD) and/or Property Business (MTD) – Annual Submission endpoints.
- Business Source Adjustable Summary (MTD) - Not required for cash basis only products.
- Individual Losses (MTD)
- Obligations (MTD) – if supporting Final Declaration
- Individual Calculations (MTD) - if supporting Final Declaration in software and **not** diverting customers into a channel where they can submit it.

### Testing requirements

HMRC requires the software to test all the APIs that they require access to. The following points relate to access to both new API subscriptions and version updates of existing API subscriptions:

- you must test all relevant endpoints documented for APIs included in the minimum functionality standards for your build, aligning with the information in your completed Production Approvals Checklist
- for APIs not included in the minimum functionality standards, you are only required to test the endpoints relating to the data sources that your software supports - where your software doesn’t support all data items, please notify [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk) separately to confirm which data items you do support, so we can take this into account when checking the testing logs

[Fraud prevention headers](/guides/fraud-prevention/) must be included in sandbox calls. A specialist team will check these.

Once testing is complete, please send details of the dummy NINO used in sandbox to [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk). You will need to contact us within 14 days of completing your API testing to enable us to view the data within our logs. 

### Production Approvals Checklist

HMRC will issue a Production Approvals Checklist asking for details of the software. This must be completed and returned to [SDSTeam@hmrc.gov.uk](mailto:SDSTeam@hmrc.gov.uk).

Production access will be granted once we are satisfied that:

- the relevant APIs and endpoints have been tested satisfactorily
- calls include compliant fraud prevention headers
- the checklist is completed satisfactorily and aligns with the testing

Please note, for access to updated APIs (that is, new versions), we don’t generally require a new Production Approvals Checklist but do need to see satisfactory testing.

### Important Considerations

- Consider a one-hour delay as part of the software workflow to update the status of obligations.
- Consider a 5-second delay before retrieving the calculation, if incorporating the calculation in your software. 
- Use APIs as efficiently as possible to avoid exceeding the rate limit.
- Build relevant error responses for your software to deal with exceptions.

###  Stateful and dynamic testing

Some APIs in the Sandbox environment allow software to test different scenarios by including ‘Gov-Test-Scenario’ headers in requests. The [Income Tax (Making Tax Digital) API documentation](https://developer.service.hmrc.gov.uk/api-documentation/docs/api?filter=income-tax-mtd) provides more information about how to use these test scenarios.

####  Dynamic scenarios

Dynamic scenarios return a response that changes depending on the parameters submitted by software, for example National Insurance number or tax year. However, the submitted data is not stored for future requests and does not affect the behaviour of other endpoints.

####  Stateful scenarios

Stateful scenarios work across groups of endpoints.

With a stateful test scenario, you can submit custom data and then retrieve or list it from a different endpoint. For example, you can submit test data through the [Self Employment Business API](/api-documentation/docs/api/service/self-employment-business-api/), and then request a summary using the [Business Source Adjustable Summary API](/api-documentation/docs/api/service/self-assessment-bsas-api/) for the same business. 

The Sandbox environment retains test data you submit for 7 days after submission, after which it is deleted automatically.

#### Stateful Sandbox user journey

To test the journey for making a Self-Employment or Property Business submission and requesting a Business Source Adjustable Summary (BSAS), complete the following steps:

<ol>
<li><p>Submit 4 stateful Self-Employment/Property Business Period Summaries (one for each quarter of the same tax year) for the desired National Insurance number, tax year and Business ID by calling one of the following endpoints: </p>
<ul>
<li><a href="/api-documentation/docs/api/service/self-employment-business-api/3.0/oas/page#tag/Self-Employment-Period-Summaries/paths/~1individuals~1business~1self-employment~1%7Bnino%7D~1%7BbusinessId%7D~1period/post">Create a Self-Employment Period Summary</a> </li>
<li><a href="/api-documentation/docs/api/service/property-business-api/4.0/oas/page#tag/UK-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1uk~1%7Bnino%7D~1%7BbusinessId%7D~1period~1%7BtaxYear%7D/post">Create a UK Property Income &amp; Expenses Period Summary</a> </li>
<li><a href="/api-documentation/docs/api/service/property-business-api/4.0/oas/page#tag/Foreign-Property-Income-and-Expenses-Period-Summary/paths/~1individuals~1business~1property~1foreign~1%7Bnino%7D~1%7BbusinessId%7D~1period~1%7BtaxYear%7D/post">Create a Foreign Property Income &amp; Expenses Period Summary</a></li>
</ul>
</li>
<li><p>Submit one stateful Self-Employment/Property Business Annual Submission for the same National Insurance number, tax year and Business ID by calling one of the following endpoints:</p>
<ul>
<li><a href="/api-documentation/docs/api/service/self-employment-business-api/3.0/oas/page#tag/Self-Employment-Annual-Submission/paths/~1individuals~1business~1self-employment~1%7Bnino%7D~1%7BbusinessId%7D~1annual~1%7BtaxYear%7D/put">Create and Amend Self-Employment Annual Submission</a> </li>
<li><a href="/api-documentation/docs/api/service/property-business-api/4.0/oas/page#tag/UK-Property-Business-Annual-Submission/paths/~1individuals~1business~1property~1uk~1%7Bnino%7D~1%7BbusinessId%7D~1annual~1%7BtaxYear%7D/put">Create and Amend a UK Property Business Annual Submission</a> </li>
<li><a href="/api-documentation/docs/api/service/property-business-api/4.0/oas/page#tag/Foreign-Property-Annual-Submission/paths/~1individuals~1business~1property~1foreign~1%7Bnino%7D~1%7BbusinessId%7D~1annual~1%7BtaxYear%7D/put">Create and Amend a Foreign Property Annual Submission</a></li>
</ul>
</li>
<li><p>Trigger a stateful Business Source Adjustable Summary for Self-Employment/Property business for the same National Insurance number and Business ID by calling the <a href="/api-documentation/docs/api/service/self-assessment-bsas-api/5.0/oas/page#/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1trigger/post">Trigger a Business Source Adjustable Summary</a> endpoint. </p>
</li>
<li><p>Retrieve a stateful Business Source Adjustable Summary for the Self-Employment/Property Business by using the Calculation ID generated in the previous step and calling one of the following endpoints:</p>
<ul>
<li><a href="/api-documentation/docs/api/service/self-assessment-bsas-api/5.0/oas/page#tag/Self-employment-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1self-employment~1%7BcalculationId%7D/get">Retrieve a Self-Employment Business Source Adjustable Summary (BSAS)</a> </li>
<li><a href="/api-documentation/docs/api/service/self-assessment-bsas-api/5.0/oas/page#tag/UK-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1uk-property~1%7BcalculationId%7D/get">Retrieve a UK Property Business Source Adjustable Summary (BSAS)</a></li>
<li><a href="/api-documentation/docs/api/service/self-assessment-bsas-api/5.0/oas/page#tag/Foreign-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1foreign-property~1%7BcalculationId%7D/get">Retrieve a Foreign Property Business Source Adjustable Summary (BSAS)</a></li>
</ul>
</li>
<li><p>Submit a stateful accounting adjustment for Self-Employment/Property Business by using the same Business ID and  Calculation ID and calling one of the following endpoints:</p>
<ul>
<li><a href="/api-documentation/docs/api/service/self-assessment-bsas-api/5.0/oas/page#tag/Self-employment-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1self-employment~1%7BcalculationId%7D~1adjust/post">Submit Self-Employment Accounting Adjustments</a></li>
<li><a href="/api-documentation/docs/api/service/self-assessment-bsas-api/5.0/oas/page#tag/UK-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1uk-property~1%7BcalculationId%7D~1adjust/post">Submit UK Property Accounting Adjustments</a></li>
<li><a href="/api-documentation/docs/api/service/self-assessment-bsas-api/5.0/oas/page#tag/Foreign-property-business/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D~1foreign-property~1%7BcalculationId%7D~1adjust/post">Submit Foreign Property Accounting Adjustments</a></li>
</ul>
</li>
<li><p>List all stateful Business Source Adjustable Summaries requested for the specific Business ID by calling the <a href="/api-documentation/docs/api/service/self-assessment-bsas-api/5.0/oas/page#/paths/~1individuals~1self-assessment~1adjustable-summary~1%7Bnino%7D/get">List Business Source Adjustable Summaries</a> endpoint.</p>
</li>
</ol>

<a href="figures/stateful-bsas-journey.svg" target="blank"><img src="figures/stateful-bsas-journey.svg" alt="Stateful journey to request a Business Source Adjustable Summary" style="width:720px;" /></a>

<a href="figures/stateful-bsas-journey.svg" target="blank">Open the stateful journey diagram in a new tab.</a>

### Product demonstration

This is the final part of the process after all preceding steps have been completed.  

During your product demonstration, HMRC expects to see a consumer-ready product for each income source your software supports; for example, Self-employment, UK property, and so on. If, in addition to the MFS APIs, you have also requested access to any non-MFS APIs, you should be ready to include these in your demonstration if requested to do so by SDST.

The journey we expect to see for an MFS build will depend on whether you are building iteratively and if so, which stage you have built to:

**Stage 1: In-year build**

1. Authorisation – ITSA scopes only.
2. Retrieve Business Details.
3. Retrieve Obligations.
4. Digitally import data into the appropriate periodic update and submit.
5. Automatically trigger and display a tax calculation.
6. Submit an amended periodic update – automatically trigger and display the calculation.
7. Demonstrate how your software returns and displays error messages to the customer.

**Stage 2: EOPS**

1. Submit details within the Annual Summary.
2. Automatically trigger and display a tax calculation.
3. Trigger a Business Source Adjustable Summary (BSAS).
4. Retrieve a BSAS.
5. Create and submit a Business Source Adjustable Summary for an accounting adjustment.
6. Automatically trigger and display a tax calculation.
7. Retrieve a Business Income Source Summary (BISS) and display it to the customer. Alternatively, the software may choose to create a BISS themselves by totalling the relevant information held in software and displaying it to the customer.
8. Show EOPS Declaration Statement.
9. Submit EOPS.
10. Demonstrate how your software returns and displays error messages to the end user.

**Note:** The end user must confirm they have read and agreed the declaration statement before the option to submit EOPS is made available.

**Stage 3: Final Declaration**

1. Create and submit a loss.
2. Create/Amend and submit disclosures (Class 2 NICs).
3. Trigger a tax calculation with the Final Declaration parameter set to ‘true’.
4. Retrieve and display this tax calculation for the customer to review.
5. Show the Final Declaration Statement – this must match the statement shown on the ITSA End to End Service Guide.
6. Submit a Final Declaration.
7. Demonstrate how your software returns and displays error messages to the end user.

**Note:** The end user must confirm they have read and agreed the declaration statement before the option to submit the Final Declaration is made available.

## Supporting customers in MTD

The customer support model guides HMRC customers to the most appropriate support. Check [GOV.UK](http://gov.uk/) and the software provider's guidance first.

Customers who have signed up to the MTD pilot can get support by contacting the dedicated Customer Support Team on 0300 322 9619 from 8am to 6pm Monday to Friday. 

The team aims to respond to queries that are not resolved at the point of contact within 2 days, and to provide further updates, if required, within 10 days.

## API lifecycle and deprecation

Each Income Tax (Making Tax Digital) API follows a lifecycle from the point where it is first published to the point where it is retired.

More specifically, every version of each API follows a lifecycle. Different versions of the same API can be at different points in the lifecycle. For example, v1.0 might be retired, v2.0 might be stable and v3.0 might be in beta.

### API status

The following table provides details about possible API statuses.

| Status | Meaning | Documentation visible? | Can be subscribed to in Developer Hub? | Endpoints enabled? |
| --- | --- | --- | --- | --- |
| Alpha| Early prototype - documentation only, available in External Test. Intended for feedback about the initial API design and documentation. Expect breaking changes and behaviour changes. | Yes | No | No |
| Beta | Live service but not stable. Breaking changes and behaviour changes are possible. | Yes | Yes | Yes |
| Stable | Stable live service. No breaking changes and only minor behaviour changes. | Yes | Yes | Yes |
| Deprecated | Set to be retired, either because a new version of the API is available or because the API is no longer supported. If applicable, a new version of the API will be available in external test when the current version is deprecated. | Yes | No | Yes |
| Retired | API is no longer in use. | No | No | No |

### Breaking changes

Any change that might break software that relies on an API is counted as breaking change.

The following table  lists changes that we consider breaking. 

| Area | Breaking changes |
| ---- | ---------------- |
| Query Parameter | <ul><li>Adding mandatory query parameter</li><li>Removing a query parameter</li><li>Renaming a query parameter</li><li>Changing an optional query parameter to be mandatory</li><li>Removing/renaming a value from an enum</li></ul> |
| Request Body | <ul><li> Adding a mandatory field </li><li> Removing a field </li><li> Renaming a field </li><li> Changing an optional field to be mandatory </li><li> Removing/renaming a value from an enum</li></ul> |
| Response Body | <ul><li> Removing a field </li><li> Renaming a field </li><li> Changing a mandatory field to be optional </li><li> Adding/renaming a value to an enum</li></ul> |
| Other | <ul><li> Changing the URL of the endpoint </li><li> Removing a resource/endpoint </li><li> Changing the semantics of a field value (for example, the value returned changes from inclusive of VAT to exclusive of VAT) </li><li> Changing validation to have stronger constraints</li></ul> |

#### Changes to errors

When we make changes to errors, we will not usually change the JSON structure returned. In the rare case when this is necessary, this will be considered a breaking change. The values of the error fields may change. 

The following table outlines which types of changes to errors are treated as breaking changes and which are not.

| Breaking changes for errors | Non-breaking changes for errors  |
| --------------------------- | -------------------------------- |
| Changing the HTTP status code to a different value | Removing an error code |
| Renaming an error code | Changing the message of an error |
| Adding a new error code (but see below) | |

If we add a new error code to an endpoint as part of a new field/object, which is not itself a breaking change, the new error is not counted as a breaking change.

For example, if we add a new optional string field to the request body and the field must satisfy a specific condition (otherwise, it fails with a new error), this error is not considered a breaking change because existing software will keep functioning as the error can be returned only if the new field is used.

### Deprecating APIs

If an API has been in production with a status of 'Stable', we aim for a deprecation period of 6 months. 

For an API in beta, we aim for a deprecation period of 6 weeks minimum.

Applications cannot subscribe to a deprecated API version, but can still call the API version if the subscription was made before the status changed.

The status of APIs is indicated in the API documentation. 

### Indicating deprecation in headers

For releases after January 2024, when an endpoint becomes deprecated, it will return the following response headers.

| Name | Meaning | Example value |
| ---- | ------- | ------------- |
| Deprecation | The deprecation date/time for this endpoint, in IMF-fixdate format. | `Sun, 01 Jan 2023 23:59:59 GMT` |
| Sunset | (optional) The earliest date/time this endpoint will become unavailable after deprecation, in IMF-fixdate format. | `Sun, 02 Jul 2023 23:59:59 GMT` |
| Link | Documentation URL for the relevant API | `https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/individual-calculations-api` |

The 'Sunset' header contains the earliest date/time that the endpoint could be retired after being deprecated. Do not rely on the availability of the endpoint after this.

The 'Sunset' header may not be returned in some rare cases, such as when the retirement date for an endpoint is uncertain.

#### Older deprecation headers

In previous releases, deprecation status could be indicated with a 'Deprecation' response header like this.

| Name | Example value |
| ---- | ------------- |
| Deprecation | This endpoint is deprecated. See the [API documentation](/api-documentation/docs/api/service/self-assessment-bsas-api/). |

**Note:** This was implemented only for the Business Source Adjustable Summary API.

### Retiring APIs

After an API has been deprecated for the amounts of time indicated above, it can be retired and the endpoints and documentation will be removed. Ensure that your application does not rely on any deprecated APIs.
