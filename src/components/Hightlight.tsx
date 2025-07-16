import useDocusaurusContext from "@docusaurus/useDocusaurusContext";
import { JSX } from "react";
import { useColorMode } from "@docusaurus/theme-common";

export default function Highlight({
  children,
  color,
}: {
  children: JSX.Element;
  color: string;
}) {
  return (
    <span
      style={{
        color: color,
      }}
    >
      {children}
    </span>
  );
}
