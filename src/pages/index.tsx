import type { ReactNode } from "react";
import clsx from "clsx";
import Link from "@docusaurus/Link";
import useDocusaurusContext from "@docusaurus/useDocusaurusContext";
import Layout from "@theme/Layout";
import Heading from "@theme/Heading";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function HomepageHeader() {
  const { siteConfig } = useDocusaurusContext();
  return (
    <header className={clsx("hero hero--primary")}>
      <div className="container">
        <Heading as="h1" className="hero__title">
          {siteConfig.title}
        </Heading>
        <p className="hero__subtitle">{siteConfig.tagline}</p>
        <p>
          I am a dedicated Software Engineer with 3 years of experience in
          developing efficient and innovative technology solutions. I have built
          a solid career in software development, focusing on creating impactful
          applications that drive business value.
        </p>
        <div
          style={{
            display: "flex",
            flexDirection: "row",
            gap: 2,
          }}
        >
          {/* <Link to='https://www.linkedin.com/in/danar-putra-pradana-8b26a71b1/' className='button button--secondary button--lg'>
                        <FontAwesomeIcon icon={['fab', 'linkedin']}/>
                        Linkedin
                    </Link> */}
          {/* <Link
            to="mailto:danarputrapradana@yahoo.com"
            className="button button--secondary button--lg"
          >
            <FontAwesomeIcon icon={["fas", "envelope"]} />
            Mail
          </Link> */}
        </div>
      </div>
    </header>
  );
}

export default function Home(): ReactNode {
  const { siteConfig } = useDocusaurusContext();
  return (
    <Layout
      title={`Hello from ${siteConfig.title}`}
      description="Description will go into a meta tag in <head />"
    >
      <HomepageHeader />
    </Layout>
  );
}
