---
title: Set up
weight: 2
description: Software developers, designers, product owners or business analysts. Integrate your software with the Income Tax API for Making Tax Digital.
---

# Set up

## Agent journey overview

Before agents can represent clients they must set up their relationships and software.

[Process diagram]

Open the agent set up process diagram in a new tab.

1. Agent reads guidance.
2. Agent creates an agent services account and copies across existing Self Assessment clients.
3. Agent is authorised by a new Self Assessment client who has signed up to Making Tax Digital for Income Tax.
4. Agent registers a client for Self Assessment.
5. Agent signs up existing clients for Making Tax Digital for Income Tax.
6. Agent chooses software.
7. Agent links software to HMRC.

## Read guidance

Individuals and agents can learn about Making Tax Digital for Income Tax by reading guidance on GOV.UK. In particular:

* Link 1
* Link 2
* Link 3

We encourage you to include links to the relevant guidance in your software.

Create an agent services account and copy across existing Self Assessment clients
To access Making Tax Digital for Income Tax, an agent must create an agent services account. This is a one-off process. 

When an agent creates their account, they can copy across any existing Self Assessment clients associated with each Government Gateway user ID they use.

An agent can also do this after creating their account, until they copied across all their existing Self Assessment clients.

[Process diagram]

Open the create an agent services account and copy across existing Self Assessment clients process diagram in a new tab.

Details about the process of creating an agent services account is available on GOV.UK at www.gov.uk/guidance/get-an-hmrc-agent-services-account.

Details about the process of copying existing Self Assessment clients across to an agent services account is available on 
GOV.UK at https://www.gov.uk/guidance/link-clients-to-your-agent-services-account. 

We encourage you to include these links in your software.

## Agent signs up clients for Making Tax Digital for Income Tax

Before signing up clients to Making Tax Digital for Income Tax, agents must first create a relationship by copying clients across to their agent services account.
Once an agent has copied all clients across to their agent services account, they can sign them up.

## The process for agents signing up their clients

1. Sign into HMRC online services using their agent services account.
2. Provide client details including National Insurance number and postcode.
3. Give and verify agent’s own email address. This is only required once.
4. Choose whether client prefers to get emails or letters.
5. Enter client’s business email address.
6. Tell clients they’ll get a verification email with a link to click on. This will verify their business email address. The link will expire after 3 days.
7. Confirm all information is correct before submitting it to HMRC.
8. Wait to hear if the client is approved. This can take up to 3 days.

The agent can now use software to submit Income Tax updates for their client.

Agents can complete the sign-up process without having to wait for their clients to verify their own email address.

## Business signs up for Making Tax Digital for Income Tax

Business owners can sign up for Making Tax Digital for Income Tax either directly or through an agent. They must complete the sign up process completely before using the service.
They need to sign up before first use, even if they have already signed up for Making Tax Digital for Income Tax.

## The process for Businesses signing up

1. Sign into HMRC online services using Government Gateway user ID and password.
2. Provide or confirm the VAT registration number.
3. Select business type and give other business information.
4. Choose preferred way of being contacted.
5. Confirm and submit information.
6. Wait up to 3 days to see if the sign up has been approved.
7. Receive confirmation that the business can now start submitting VAT Returns using compatible accounting software.

## Link software to HMRC

Businesses and agents using your software to connect to the [ITSA (MTD) API](https://developer.service.hmrc.gov.uk/api-documentation/docs/api/service/self-assessment-api/2.0) must grant authority to your software to interact with HMRC on their behalf. We use the open standard [OAuth 2.0](https://oauth.net/2/) (opens in a new tab), which involves the business or agent signing in via their Government Gateway account and following the grant authority user journey.
 
<a href="figures/link-software-to-hmrc.svg" target="blank"><img src="figures/link-software-to-hmrc.svg" alt="Link software to HMRC" style="width:520px;" /></a>
 
[Open the link software to HMRC process diagram in a new tab.](https://developer.service.hmrc.gov.uk/guides/vat-mtd-end-to-end-service-guide/documentation/figures/link-software-to-hmrc.svg)

1.	Business or agent requests to link your software to HMRC.
2.	Your software launches the grant authority user journey.
3.	Business or agent views the HMRC start page for an overview of the process and chooses to continue.
4.	Business or agent signs in with their Government Gateway user ID and password (**agents must use their new agent services user ID**).
5.	Business or agent registers for or completes 2-step verification as applicable.
6.	Business or agent completes identity checks if applicable.
7.	Business or agent grants authority for the software to interact with HMRC on their behalf.
8.	HMRC generates an OAuth token for the business or agent.
9.	Your software stores the business or agent’s OAuth token for later use in API calls on their behalf.

Business and agents authenticate directly with us using their Government Gateway user ID and password, and grant the software the authority to interact with HMRC on their behalf. They grant this for a set of functions called API scopes which are required for each ITSA (MTD) endpoint.

In the case of agents, they must sign in to their Government Gateway account with the user ID and password for their new agent services account, which was generated as part of the agent services account journey.

We then generate an OAuth 2.0 access token for the software which is specific to the business or agent. The software must pass this access token in subsequent API requests as explained in authorisation of user-restricted endpoints.
