export function coloring(tag: string) {
  switch (tag) {
    case "Fullstack Developer":
      return "text-green-300";
    case "Freelance":
      return "text-red-300";
    case "Mobile Developer":
      return "text-blue-300";
    default:
      return "text-blue-300";
  }
}
