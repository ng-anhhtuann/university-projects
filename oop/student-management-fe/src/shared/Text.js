import React from 'react';

export default function Text({
  title,
  fontSize = 'text-[24px]',
  fontWeight = 'font-[700]',
  margin = 'mb-5',
}) {
  const titleClassName = `${fontWeight} text-[#000000] ${fontSize} text-center ${margin}`;

  return (
    <h1 className={titleClassName}>
      {title.toUpperCase()}
    </h1>
  );
}
