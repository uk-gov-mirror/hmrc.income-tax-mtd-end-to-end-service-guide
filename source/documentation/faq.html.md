---
title: Frequently Asked Questions
weight: 50
---

# Frequently Asked Questions #

**1. What is the digital start date for EOPS? For example, if a business has 30 September as the year end, could you confirm that the quarterly updates start from 6 April 2024 and the first EOPS will be required on 31 January 2027 for 01/10/2026-30/09/2027?**

The digital start date for all existing individuals mandated to use MTD will be 06/04/2024. From this date, customers need to start meeting the MTD requirements and this is also the beginning of the first quarterly period. The requirement to provide an EOPS commences from the beginning of the first period which starts after or on the digital start date. In the example provided, the customer will need to submit their first EOPS for the period covering 01/10/2024 through 30/09/2025. The deadline for the submission of the EOPS will be 31/01/2027. EOPS for non- tax year basis periods will fall into tax year 25/26 which is due on 31/01/2027.

**2. The Statutory Instrument reads as if basis period reform is proceeding. Will it be modified if it is not?**

The Statutory Instrument (SI) won't need to be amended if basis period reform goes ahead. It has been drafted such a way as to be 'agnostic' of basis period reform, so changes won't be required.

**3. Where taxpayers are submitting quarterly updates under MTD, can they still submit Self -Assessment returns or do they have to submit non-business income via MTD APIs?**

No, they won't have to submit SA returns as well. They can choose whether to use MTD to submit non-business income. If software doesn't support this, then a customer can provide this information to HMRC using the HMRC Update and Submit service. It is not mandatory to submit this income through software, but your software may choose to support the full end-to-end customer journey.

**4. Could you confirm what the process is for making adjustments for quarterly updates please? Is there any details being provided around rules on this based on material adjustments? Can an already submitted period be reopened?**

You can amend your quarters during the year by making amendments to the information you have already provided and resubmitting your quarter. You will need to confirm this is correct at the point you make your final declaration.

**5. Some documents discuss bridging software, is that to be allowed for ITSA MTD?**

Yes, but it will need to link digitally to whatever the customer uses to maintain their digital records.

**6. Will the non-business income MTD service be available to be added to gov.uk verify and/or government gateway accounts?**

We have the view and change MTD services currently. Customers will be able to access their submission services from there.

**7. Will the Tax Calculation API have one endpoint for the calculation and another for any errors?**

Currently the design will have this calculation and error messages.

**8. Will Individual Calculations (MTD) API return data for all calculation IDs or only latest?**

There is a List All Self-Assessment Calculations endpoint within the Individual Calculations (MTD) API that will return all calculation IDs for all calculations performed in previous years by entering a date parameter on the call. You can then use the other endpoints within the Individual Calculations (MTD) API to retrieve the details.

**9. Will this updated roadmap be shared with the developer community?**

Yes, we will share this when we get new iterations. We will provide a timeline for when you can expect an updated roadmap.

**10. When will we start to see HMRC's plans for Partnerships (SA800) and Trusts (SA900)?**

Partnerships will not come in to MTD until April 2025 and trusts have been exempted from MTD for Income Tax.

**11. At the moment the sandbox API returns a lot of canned data. When can we expect end points to be fully functional? For example being able to trigger SA Tax Calculations and then retrieve those calculations.**

There are no plans to make endpoints fully functional as in the live environment.

Currently, the majority of our APIs do not have stateful stubs. The reason for not supporting stateful stubs is due to the complexity of creating, maintaining and ensuring consistency across our API suite and the limited availability of backend systems in test environments such as the sandbox (an integration environment, and not a production copy with all the backend systems in place).

**12. Where a taxpayer has a small amount of property income (say £3k) but also has some partnership Income (say £20k) will they still have to submit Property Income via MTD by April 2024, even though the Partnership income does not get mandated at this stage?**

In this example, the only income that counts for the individuals’ £10k threshold is the property income. The customer would not be mandated to use MTD for income tax in this example. When partnerships come into the scope of MTD ITSA they will have their own £10K threshold for the total partnership income (not for any one partner's individual share of the profits).

**13. On the control slide, you state the earliest tax year that certain income types will be supported. For those income types supported from 2021/2022 , when will it be possible to register those users for MTD? Given they need to be registered in advance of the year commencing**

Those income types would be supported from 2021/2022, there will be further guidance from HMRC for when people need to sign up.

**14. Is there a website discussion forum where detailed technical development questions can be discussed and shared by this community in order to help each other?**

No, instead we have created a MTD newsletter to provide all information that we think will be useful. This will be shared across the software developer community. Please suggest any feedback of what you would like to see in this newsletter to the Software Developer Support Team mailbox.

**15. Can you confirm if periodic updates can be posted on the sandbox and if so what business/employment do you use. We get the error that matching resource cannot be found.**

Yes you can, if it is not working then you may be using the wrong API. Please see the [End to End Service Guide](/documentation/businessandpropertyincome.html#submit-income-and-expense-updates-for-self-employment-and-property-businesses)

In order to post periodic updates in Sandbox for self-employment and UK property, a business has to be added using the "Add a self-employment business [test support]" and "Add a UK property business [test support]" endpoints within the Self Assessment (MTD) API.

The "selfEmploymentId" that is returned from the "Add a self-employment business [test support]" call is then used when posting the self-employment periodic update.

**16. It seems you are relying solely on the software community to recruit eligible 'customers' to partake in the pilot. As you have access to a database that contains a list of every eligible customer, what activities will you be doing to promote and recruit customers yourselves to join the pilot?**

This is not the case; we are developing plans on our engagement with customer segments and how we can use external stakeholder groups to disseminate messages for the ITSA pilot. At the moment it makes sense that we are reaching out to software developers to increase the number of compatible products, but this is expanding to other segments.

**17. On the pilot, has there been consideration into breaking the requirements down? i.e. can software providers join the pilot just for quarterly updates to start with?**

At the moment no, as we have not granted production credentials, but we are looking to see how we can make this work and we are considering it.

**18. The statutory instrument references a calendar quarters election, but the stakeholders pack does not. Which is correct?**

As per regulation 7, the standard quarterly periods for most customers will be:

* 6th April to 5th July
* 6th July to 5th October
* 6th October to 5th January
* 6th January to 5 April

However, customers will be able to elect to use calendar quarters instead, in order to align their reporting obligations.

**19. On MTD ITSA software compatibility page the names of the sections “software available” and “software in development” are slightly misleading. Products listed in “software in development” section have been granted production credentials and can be used in production. Could the “software in development” section be renamed to reflect the fact that products in this section are production ready? This will add more confidence for the customers joining the pilot.**

In general, the current Software Choices page is being looked at. We are looking to develop a more interactive software choices viewer.

**20. I have a question regarding income from employment. Who is actually responsible for providing this income for a person via MTD? The employer or the employee?**

The employer, if you support employment it would be advisable to support endpoints but it will come from the employer end year. HMRC will use the employment income provided by the employer and include the year-to-date employment income in the in-year tax calculation and the end of year employment income in tax calculations provided after the tax year has ended.

The employment endpoints are held in the "Individuals Income Received (MTD) API" and these can be used to check and correct the information after the tax year has ended. So, if you support employment income it is advisable to support the appropriate endpoints.

Please see [further guidance](/documentation/additional-income.html#employments).

**21. Can you confirm that free software only needs to provide replacement for SA1xx forms and not full tracking of the users’ accounts? Documentation describes it needs the full data of the results e.g. customer transactions.**

Free software will need to enable customers to meet their MTD obligations i.e. maintain digital records of their business transactions, submit quarterly updates and EOPS and finalise their business income. As stated, we will be publishing the notices which will set out further detail on the records that customers need to maintain and the information they need to submit via quarterly updates and EOPS.

**22. Should the wording be changed to tax period, rather than annual accounting period, given the change of submissions to a tax year basis?**

We are aware that we need to make terminology as simple as possible. We are trying to include software developers in this. There are some terms that you should see soon that are changing to make it more customer friendly. Happy to receive feedback to understand what works.

**23. What proportion of MTD VAT submissions are made using free software? Are there any statistics on this?**

We know which products are free to use for VAT but cannot track the actual submissions as some software developers offer both free and paid for versions but both access the APIs using the same credentials.

**24. Is there an expected date for when the further notices will be released please?**

They will not be too far behind the regulations we have just made.

**25. Is there a minimum number of free software providers you are aiming to hit in order to satisfy the intention for free software to be available? Particularly if a freemium model proves unsustainable.**

We have no target in mind - what we want to see though is our customers offered a choice of free products. We will continue to encourage all ITSA software developers to consider free options and will keep a close eye on how the market develops.

**26. If I have two properties and my income is below £85,000, will I still be eligible for free software?**

If the customers total income from property is in the range £10-85k (and they otherwise meet the eligibility criteria for free software), then yes.

**27. Given the assumption of low take up of free software, has the market already decided that free software is not needed?**

If the market as a whole doesn't bring forward sufficient choice to customers of free offerings, then the Government may ask HMRC to intervene. This is obviously not something we want to do. We want the market to support the Government's commitment to taxpayers. But we will keep a close eye on what’s happening. HMRC have no plans currently to develop a free product.

**28. So, a higher rate taxpayer could be eligible for free software?**

Yes, if they are a small business and the business meets the eligibility criteria for free software.

**29. Is the Agent Auth API in sandbox fully testable now? (i.e. last I used this API, as a client, I was not able to accept OR cancel an invitation from my agent to act on my behalf).**

The Agent Authorisation API along with the Agent Authorisation Test Support API (which is used to provides test- only ability to accept or reject an authorisation request created with Agent Authorisation API) is working in the sandbox environment.

**30. At the moment you cannot register a user for MTD via API, is this going to be a requirement?**

There are no plans to deliver a third party API sign up solution, this has been ruled out by security.

**31. Is the intention for HMRC's new Income Tax service to support non-business income for all taxpayers, or will it have similar limitations to the existing Self-Assessment service (e.g. non-residents, multiple gains)? Current service is sensitive, and limitations apply. Just wanted to know if customers will still have these limitations.**

The intention is that customers will be able to submit their non-business income either through their MTD compatible software or the HMRC submission service. We will continue to refine the MTD for Income Tax system and eliminate known issues as we expand the pilot prior to mandation.

**32. What are the plans to support transitional adjustments if a customer moves between cash basis and accruals basis?**

Customers will be able to make any necessary adjustments when they submit their end of period statement after the end of the tax year.

**33. How will it work where someone uses MTD for quarterly submissions and Self-Assessment for the end of year return? This seems like a recipe for disaster.**

If you are submitting quarterly submissions, you are in MTD and you won't submit a tax return at the end of the year. If software doesn't support all user sets, then they can use the Update and Submit an Income Tax Return service to submit that information.

Current policy is that all MTD ITSA software needs to be able to support 'crystallisation' (end of year declaration and self-assessment of liability). We agree that it is vital that the correct total income information is played back to the software at crystallisation, taking account of all the ways the customer has submitted information to HMRC relating to that tax year. We are confident that this will work smoothly.

**34. What impact MTD will have on foster carers and those in receipt of HS236 Qualifying care relief: foster carers, adult placement carers, kinship carers and staying put carers (2018)? Will this income still be subject to SA rather than MTD?**

The only income sources that need to be reported via MTD for Income Tax are self-employment business income and property income where the customer's total income from these sources (their 'qualifying income') exceeds £10,000 in a tax year.

Other forms of personal income will be reportable via MTD software or HMRC's submission service and they will not contribute towards a customer’s qualifying income.

**35. Where can I find accurate and usable documentation so that I can build my software?**

HMRC provides the documentation you need to help build a product. The easiest way to access this, and make sure you are up to date with latest announcements and developments is to [register with HMRC as a software developer](https://www.gov.uk/government/collections/register-as-a-software-developer.).

**36. Where can I test my software properly and for all user types so that I am confident to deploy it?**

HMRC provides a testing platform to registered software developers. This [page](https://www.gov.uk/government/collections/register-as-a-software-developer) explains how you register and from there obtain documentation that explains how to access the testing platform.

**37. Is registering a customer for MTD via APIs and adding a self-employment/property business via API going to be available in production in future?**

There are no plans to deliver a third party API sign up solution, this has been ruled out by security.

**38. Will HMRC be sharing their roadmap for communications? As software providers we will be more than happy to help with getting the message out there but that will still leave people who don't use software or use Accountants unaware of MTD?**

Yes, we will share this when we get new iterations. We will provide a timeline for when you can expect an updated roadmap.

**39. We note that some of the APIs contain required information that isn't currently mandated under Self- Assessment. For example, under Self-Assessment, a taxpayer with share scheme income just reports the total taxable amount in box 1 on SA101 page Ai 2. However, under MTD, the taxpayer would be required to report the plan type, number of shares, amounts paid for optioned, etc. Please can you confirm that the intention is for taxpayers to submit more detail under MTD than under Self-Assessment?**

APIs have been designed to collect information the customer will need to complete their working sheet. The working sheet is used to arrive at the total taxable amount but customers aren't required to submit them. This query also concerns a non-mandated income source which customers aren't required to submit data on.

**40. Can you clarify the digital start date for the self-employment?**

The digital start date for taxpayer who is already self-employed and whose qualifying income exceeds £10,000 will be 6 April 2024. From this date they will need to start meeting the requirements set out in the regulations e.g. maintaining digital records in their MTD software, submitting a quarterly update every 3 months and an EOPS in line with their accounting period/basis period and submitting a final declaration.

**41. What impact will MTD have on foster carers and those in receipt of HS236 Qualifying care relief: foster carers, adult placement carers, kinship carers and staying put carers (2018)? Will this income still be subject to Self-Assessment rather than MTD?**

The only income sources that need to be reported via MTD for Income Tax are self-employment business income and property income, where the customer's total income from these sources (their 'qualifying income') exceeds £10,000 in a tax year.

Other forms of personal income will be reportable via MTD software or HMRC's submission service but there is no requirement to do this and they will not contribute towards a customer’s qualifying income.

**42. You have advised that qualifying business income relates to box 15 on the SA103F and box 20 on the SA105. Please can you confirm whether any of the following boxes are included; SA103F box 16, SA105 box 5, SA105 box 22, SA105 box 23, SA106 box 14, SA106 box 16.**

We can confirm that all of these boxes will be included where relevant for the taxpayer. If you’re domiciled or resident outside the UK you only need to follow Making Tax Digital for Income Tax rules for your UK self- employment and property income.

**43. If two or more taxpayers have a joint property business under MTD, does one taxpayer submit the total income and expenses for the property business, or does each of the taxpayers submit their share of the income and expenses?**

The criteria for MTD mandation are based on the total property income and/or self-employment business income that an individual receives.

If a property is jointly owned by individuals and each individual receives less than £10,000 in property income and has no other property income or income from self-employment, then they will not be mandated to sign up to MTD for Income Tax. If both have qualifying income that exceeds £10,000, then they will both need to follow the MTD requirements in relation to the qualifying income that they personally receive.

In practice though, we expect it will be possible for these customers to maintain joint digital records and meet other MTD obligations through their shared software.

**44. You have advised that "Crystallisation refers to the process by which customers will make adjustments and claim any reliefs as part of finalising their business income for the period. They will then be able to submit data on personal income sources as part of their final declaration for that tax year." Please can you confirm that the adjustments and relief claims for a business are made in the End of Period Statement?**

Providing an End of Period Statement - This is the process that allows the customer to finalise the profit or loss for any one source of business income (Including adjustments and Reliefs)

Providing a Final Declaration - This is the process that allows the customer to finalise their tax position for any one tax year, taking into account all sources of chargeable income and gains, whether business income or otherwise. In other words, this process brings together all the data that a taxpayer needs to provide to HMRC to reach their final tax liability for a specific year. 

**45. Thanks for confirming that the taxpayer would be mandated to use MTD for Income Tax in 2024/2025 after exceeding the income threshold in 2022/2023. As the income threshold hasn't been exceeded in 2023/2024, please can you advise whether MTD would be mandated in 2025/2026, or would the income exemption in s25 of the draft regulations apply?**

In general, and exemptions aside, existing customers will be mandated when they submit a Self-Assessment return declaring a qualifying income in excess of £10,000 e.g. they will submit a their 22/23 return by 31 January 2024 and will be mandated to follow the MTD requirements from 6 April 2024.

Customers that start trading after 6 April 2023 will be mandated following the submission of a SA return (for Year 1) declaring a qualifying income in excess of £10,000. They will then need to follow MTD requirements from the beginning of Year 3 (or Year 4 if the conditions of Reg 4 (3) are met).

**46. If a business switches from 3-line accounting to full accounting during the period, would they have to resubmit their quarterly updates or just adjust the annual figures via the Business Source Adjustable Summary?**

A business can switch from three-line accounts to categorised expenses mid-year but must re-submit any previously submitted three-line accounts-based updates before they can do their EOPS. They will not be able to EOPS with a combination of three-line accounts and categorised expenses in the same year.


**47. If a sole trade becomes a partnership during a tax year before partnerships are mandated, what are the reporting requirements for the sole trade?**

On the formation and registration of the partnership, assuming that all of the taxpayer's relevant income is now passing through the partnership, the individual would cease to be mandated to use MTD.

**48. If a sole trade becomes a partnership during a tax year after partnerships are mandated, what are the reporting requirements for the sole trade and the partnership?**

It would depend on the circumstances. As above, if the individual ceased to be mandated for MTD based on their own personal income, then they would no longer be required to meet the MTD requirements. If the partnership's qualifying income exceeded the income threshold, then it would be required to meet MTD requirements through a nominated partner.

**49. If a partnership becomes a sole trade during a tax year before partnerships are mandated, what are the reporting requirements for the sole trade?**

On the dissolution of the partnership, the individual would need to register as a sole trader. They would then be mandated for MTD if their qualifying income exceeded the income threshold, as any new trader would.

**50. If a partnership becomes a sole trade during a tax year after partnerships are mandated, what are the reporting requirements for the sole trade and the partnership?**

On the dissolution of the partnership its MTD obligations would cease. The individual would then need to register as a sole trader. They would then be mandated for MTD if their qualifying income exceeded the income threshold, as any new trader would.

**51. What happens if someone signs up but doesn’t reach £10,000 threshold, can they come back out of MTD?**

It is completely voluntary for non-mandated customers so yes if they sign up and change their mind they can revert to submitting a Self-Assessment return.

**52. What happens if you don’t sign up at the beginning of the year as you’re not expecting to reach the £10,000 threshold, when do you become mandated?**

If they don’t make the £10,000, they won't be mandated. If they get to the end of the year and have made £10,000 or more they will have to submit retrospectively for that year in MTD as they would be mandated.

**53. Will the non-business income MTD service be available to be added to gov.uk verify and/or government gateway accounts?**

We have the view and changed MTD services currently. Customers will be able to access their submission services from there.

**54. Where a taxpayer has a small amount of property income (say £3k) but also has some partnership Income (say £20k) will they still have to submit Property Income via MTD by April 2024, even though the Partnership income does not get mandated at this stage?**

In this example, the only income that counts for the individual's £10k threshold is the property income. The customer would not be mandated to use MTD for income tax in this example. When partnerships come into the scope of MTD ITSA they will have their own £10K threshold for the total partnership income (not for any one partner's individual share of the profits).

**55. If a taxpayer submits quarterly updates and EOPS via MTD, can they submit a Self Assessment return via XML instead of a Final Declaration?**

During the pilot the customer can revert back to submitting an SA return however, all information for that financial year must be included as the information submitted in SA will overwrite the information in MTD. Once mandated the customer will be unable to submit an SA return.

**56. If a business switches from cash accounting to accruals during the period, would they have to resubmit their quarterly updates under accruals basis or just adjust the annual figures via the Business Source Adjustable Summary?**

Customers will need to decide, from the start of each year, which accounting basis, accruals or cash, they will be using that year. If they decide to change their accounting basis, then they will need to submit adjustments to reflect this.

While we expect that the necessary adjustments will be entered via the annual adjustments process the system requirements to allow change are currently under construction and as such the details will be communicated in due course.

**57. To meet the requirements for the list we must successfully complete a periodic return for 2 unique customers, could you confirm if the periodic return is a quarter or could this for example be one day?**

The periodic return can be a daily submission yes, as interacting with the APIs in the live environment is the same if you are entering data for a day, week, month etc.

**58. With regards to the BusinessID field, as this is a 15-digit field for individuals with more than one source of business income will this be clear each time which business this relates to? Will the individual be given the ID at point of registration?**

At sign up the trading name is captured; users will use this to distinguish between multiple self-employment sources. Business ID is not given to the customer.

**59. Resident landlords get £7,500 tax-free as part of the Rent a Room Scheme. So will MTD ITSA kick in when they get over £10,000? So theoretically they could be declaring just £2,501?**

If a customer has property/trading receipts that fall under the thresholds for the rent-a-room scheme (£7,500), the property allowance (£1,000) or the trading allowance (£1,000) and are not required to submit a return, then this income will not be considered for MTD's purposes. We are continuing to explore the interactions between MTD and the Rent-a-Room scheme in other scenarios.

**60. Currently, the government says landlords using Self-Assessment pay Class 2 NICs if they’re actually running a property business and profits are £6,515 or more. Does this continue under MTD ITSA? The GOV.UK site only mentions Class 4 NICs.**

The introduction of MTD for Income Tax will have no impact on whether a landlord is required to pay Class 2 NICs or not.
