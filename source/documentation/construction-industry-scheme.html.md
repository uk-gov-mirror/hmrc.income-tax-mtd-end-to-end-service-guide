---
title: Construction Industry Scheme
weight: 4
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

<!--- Section owner: MTD Programme --->

# Construction Industry Scheme

These endpoints allow a subcontractor working within the [Construction Industry Scheme (CIS)](https://www.gov.uk/what-is-the-construction-industry-scheme) to retrieve, submit, override and delete the gross income, cost of materials and tax deducted amounts if they disagree with the amounts submitted on their behalf by the contractors they have worked for during the tax year. The tax deducted monthly by the contractor will be credited to the subcontractor within their tax calculation during the tax year.
 
When the user sends their quarterly update and retrieves a tax calculation this will include the tax deducted by the contractor, the user may want to call these endpoints to query or check the data supplied by the contractor.
 
When the user does not agree with the data the contractor has reported to HMRC, the user can submit what they believe to be the correct amounts, or if no data from the contractor is included in the calculation, the user may want to submit the details so that they can be given credit for the tax the contractor has deducted on their behalf. This can only be supplied after the end of the tax year.

During the year, the user should also query this with the contractor as they may need to amend the monthly return they make to HMRC, or query with the contractor why monthly returns are not being made to HMRC. 
 
If the user has submitted data after the end of the year because no data was supplied by the contractor or they did not agree with the data the contractor has reported to HMRC but the user later realises the data they submitted is incorrect, they can simply delete the data using the delete endpoint.
 
If any data the user has submitted is different from the records HMRC hold the user data is accepted. Any discrepancies will be flagged by the system for a HMRC review.
 
[Create CIS Deductions for Subcontractor](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/cis-deductions-api/1.0#_create-cis-deductions-for-subcontractor-test-only_post_accordion) - this endpoint allows a user to create a customer override to the CIS deductions which have been previously populated by data submitted directly to HMRC by the contractor, or create CIS deductions if no data has been submitted to HMRC by the Contractor. A National Insurance number must be provided.

<a href="figures/cis-create-cis.svg" target="blank"><img src="figures/cis-create-cis.svg" alt="CIS create diagram" style="width:720px;" /></a>
<a href="figures/cis-create-cis.svg" target="blank">Open the CIS create deduction diagram in a new tab</a>.

[Amend CIS Deductions for Subcontractor](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/cis-deductions-api/1.0#_amend-cis-deductions-for-subcontractor-test-only_put_accordion) - this endpoint allows a user to amend the override CIS deductions that have been previously submitted by the user. A National Insurance number and submission ID must be provided.

<a href="figures/cis-amend-cis.svg" target="blank"><img src="figures/cis-amend-cis.svg" alt="CIS amend diagram" style="width:720px;" /></a>
<a href="figures/cis-amend-cis.svg" target="blank">Open the CIS amend deduction diagram in a new tab</a>.

[Retrieve CIS Deductions for Subcontractor](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/cis-deductions-api/1.0#_retrieve-cis-deductions-for-subcontractor-test-only_get_accordion) - this endpoint allows a user to retrieve the latest CIS deductions position and whether contractor or user data has been used in the latest calculation. A National Insurance number and submission ID must be provided.

<a href="figures/cis-retrieve-cis.svg" target="blank"><img src="figures/cis-retrieve-cis.svg" alt="CIS create diagram" style="width:720px;" /></a>
<a href="figures/cis-retrieve-cis.svg" target="blank">Open the CIS retrieve deduction diagram in a new tab</a>.

[Delete CIS Deductions for Subcontractor](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/cis-deductions-api/1.0#_delete-cis-deductions-for-subcontractor-test-only_delete_accordion) - this endpoint allows a user to delete user submitted CIS overrides which have been previously submitted. A National Insurance number and submission ID must be provided.

<a href="figures/cis-delete-cis.svg" target="blank"><img src="figures/cis-delete-cis.svg" alt="CIS delete diagram" style="width:720px;" /></a>
<a href="figures/cis-delete-cis.svg" target="blank">Open the CIS delete deduction diagram in a new tab</a>.




