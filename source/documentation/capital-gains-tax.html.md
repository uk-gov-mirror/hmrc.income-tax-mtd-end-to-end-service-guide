---
title: Capital Gains Tax | Income Tax (MTD) End-to-End Service Guide
weight: 31
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Capital Gains Tax

Capital Gains Tax is a tax on the profit when someone sells or disposes of an asset that has increased in value. Customers may need to report on the following types of asset:

* residential property
* other property 
* listed and unlisted shares and securities 

For more information on capital gains tax, see [Capital Gains Tax: what you pay it on, rates and allowances](https://www.gov.uk/capital-gains-tax).

MTD customers can also report any losses they have made. This charge may be set against earlier or later years. When the customer sells or disposes of the whole or part of a UK residential property and is liable to pay CGT, they must tell HMRC within a specific time following the date of completion of the sale. For more information on the reporting requirement, see [Report and pay your Capital Gains Tax: If you sold a property in the UK on or after 6 April 2020](https://www.gov.uk/report-and-pay-your-capital-gains-tax/if-you-sold-a-property-in-the-uk-on-or-after-6-april-2020). For non-resident customers, see [Tell HMRC about Capital Gains Tax on UK property or land if you’re not a UK resident](https://www.gov.uk/guidance/capital-gains-tax-for-non-residents-uk-residential-property), which advises on how these gains must be reported in year.

The customer can create, update, or delete their capital gains tax in software only after the end of the tax year. If they need to make changes during the year, they need to use HMRC online services. In some cases, customers must report and pay before they submit their final declaration. However, this information will still need to be included in their final declaration if they are a Self Assessment or MTD customer.

An MTD customer can do the following: 

* view CGT Residential Property Disposals for PPD, non-PPD and other capital gains and disposals
* create or amend CGT Residential Property Disposals for PPD, non-PPD and other capital gains and disposals
* delete CGT Residential Property Disposals for PPD, non-PPD and other capital gains and disposals

## Viewing CGT

At any time, a customer can view their capital gains tax information. In software, this information is retrieved using the following endpoints:

* [Retrieve All CGT Residential Property Disposals and Overrides (Includes PPD and Non-PPD)](/api-documentation/docs/api/service/individuals-income-received-api/2.0/oas/page#tag/Capital-Gains-on-Residential-Property-Disposals/paths/~1individuals~1income-received~1disposals~1residential-property~1%7Bnino%7D~1%7BtaxYear%7D/get)
* [Retrieve Other Capital Gains and Disposals](/api-documentation/docs/api/service/individuals-income-received-api/2.0/oas/page#tag/Other-Capital-Gains-and-Disposals/paths/~1individuals~1income-received~1disposals~1other-gains~1%7Bnino%7D~1%7BtaxYear%7D/get)

## Creating or Amending CGT

Customers can create or amend the different types of CGT information after the end of the tax year. This change must be done before they submit their final declaration. In software, this information is updated using the following endpoints:

* [Create and Amend ‘Report and Pay Capital Gains Tax on Property’ Overrides](/api-documentation/docs/api/service/individuals-income-received-api/2.0/oas/page#tag/Capital-Gains-on-Residential-Property-Disposals/paths/~1individuals~1income-received~1disposals~1residential-property~1%7Bnino%7D~1%7BtaxYear%7D~1ppd/put)
* [Create and Amend CGT Residential Property Disposals](/api-documentation/docs/api/service/individuals-income-received-api/2.0/oas/page#tag/Capital-Gains-on-Residential-Property-Disposals/paths/~1individuals~1income-received~1disposals~1residential-property~1%7Bnino%7D~1%7BtaxYear%7D/put)
* [Create and Amend Other Capital Gains and Disposals](/api-documentation/docs/api/service/individuals-income-received-api/2.0/oas/page#tag/Other-Capital-Gains-and-Disposals/paths/~1individuals~1income-received~1disposals~1other-gains~1%7Bnino%7D~1%7BtaxYear%7D/put)

## Deleting CGT

Customers can delete different types of CGT only after the end of the tax year and only after they have created CGT using software. However, this change must be done before they submit their final declaration.  In software, this deletion is made using the following endpoints:

* [Delete ‘Report and Pay Capital Gains Tax on Residential Property’ Overrides](/api-documentation/docs/api/service/individuals-income-received-api/2.0/oas/page#tag/Capital-Gains-on-Residential-Property-Disposals/paths/~1individuals~1income-received~1disposals~1residential-property~1%7Bnino%7D~1%7BtaxYear%7D~1ppd/delete)
* [Delete CGT Residential Property Disposals](/api-documentation/docs/api/service/individuals-income-received-api/2.0/oas/page#tag/Capital-Gains-on-Residential-Property-Disposals/paths/~1individuals~1income-received~1disposals~1residential-property~1%7Bnino%7D~1%7BtaxYear%7D/delete)
* [Delete Other Capital Gains and Disposals](/api-documentation/docs/api/service/individuals-income-received-api/2.0/oas/page#tag/Other-Capital-Gains-and-Disposals/paths/~1individuals~1income-received~1disposals~1other-gains~1%7Bnino%7D~1%7BtaxYear%7D/delete)
