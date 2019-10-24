---
title: Set up
weight: 2
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

# Set up

## Agent journey overview

AWAITING CONTENT OR LINKS

## Business journey overview

AWAITING CONTENT OR LINKS

## Read guidance

AWAITING CONTENT OR LINKS

## Create an agent service account

this can link to agent team guidance
 
## Link existing clients  

this may be wrapped up in the one above

## Link new clients 

– this may be wrapped up in the one above

## Register for ITSA 

we should link of to the existing process for this

## Agent signs up client for MTD ITSA

## Business signs up for MTD ITSA

## Choose Software

HMRC publishes a [list of compatible software](https://www.gov.uk/guidance/find-software-thats-compatible-with-making-tax-digital-for-income-tax) for Making Tax Digital on GOV.UK.

A business or agent will need to complete the authentication process with HMRC within their chosen software to obtain their obligation dates from HMRC via an API call.

They will be able to enter transactional level information into their record-keeping software for anything relating to business income as a minimum. Software can also provide users with the ability to provide information for non-business income (personal income). HMRC only require that each package made available to customers complies with the [Terms of use.](https://developer.service.hmrc.gov.uk/api-documentation/docs/terms-of-use)  Vendors and developers will also need to agree to the [Terms of use.](https://developer.service.hmrc.gov.uk/api-documentation/docs/terms-of-use) These have to be accepted before production credentials are issued.

[Guidance listing software](https://www.gov.uk/guidance/software-for-sending-income-tax-updates) that is compatible with Making Tax Digital for Income Tax is available.


## Link software to HMRC

Businesses and agents using your software to connect to the [ITSA (MTD) API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0) must grant authority to your software to interact with HMRC on their behalf. We use the open standard [OAuth 2.0](https://oauth.net/2/) (opens in a new tab), which involves the business or agent signing in via their Government Gateway account and following the grant authority user journey.
 
<a href="figures/link-software-to-hmrc.svg" target="blank"><img src="figures/link-software-to-hmrc.svg" alt="Link software to HMRC" style="width:520px;" /></a>
 
[Open the link software to HMRC process diagram in a new tab.](https://developer.service.hmrc.gov.uk/guides/vat-mtd-end-to-end-service-guide/documentation/figures/link-software-to-hmrc.svg)

1.	Business or agent requests to link your software to HMRC.
2.	Your software launches the grant authority user journey.
3.	Business or agent views the HMRC start page for an overview of the process and chooses to continue.
4.	Business or agent signs in with their Government Gateway user ID and password (agents must use their new agent services user ID).
5.	Business or agent registers for or completes 2-step verification as applicable.
6.	Business or agent completes identity checks if applicable.
7.	Business or agent grants authority for the software to interact with HMRC on their behalf.
8.	HMRC generates an OAuth token for the business or agent.
9.	Your software stores the business or agent’s OAuth token for later use in API calls on their behalf.

Business and agents authenticate directly with us using their Government Gateway user ID and password, and grant the software the authority to interact with HMRC on their behalf. They grant this for a set of functions called API scopes which are required for each ITSA (MTD) endpoint.

In the case of agents, they must sign in to their Government Gateway account with the user ID and password for their new agent services account, which was generated as part of the agent services account journey.

We then generate an OAuth 2.0 access token for the software which is specific to the business or agent. The software must pass this access token in subsequent API requests as explained in authorisation of user-restricted endpoints.


