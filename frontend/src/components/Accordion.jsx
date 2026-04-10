export default function Accordion({ title, content, isExpanded, onToggle, swapButton }) {
    return (
        <div
            className={`bg-white w-36 md:w-56 rounded-lg
                overflow-hidden transition-all duration-300 
                shadow-md border border-gray-200 ${
                    isExpanded ? "max-h-96" : "max-h-24"
                }`}
        >
            {/* Header */}
            <div
                className="flex flex-col items-center px-6 pt-4 pb-2 cursor-pointer"
                onClick={onToggle}
            >
                <div className="text-base font-bold text-center break-all">{title}</div>

                {/* Swap button when collapsed */}
                {!isExpanded && swapButton && (
                    <div className="mt-1">{swapButton}</div>
                )}
            </div>

            {/* Expanded content */}
            <div
                className={`px-4 pb-3 transition-all duration-300 whitespace-pre-line ${
                    isExpanded ? "opacity-100" : "opacity-0"
                }`}
            >
                <div className="text-sm">{content}</div>

                {/* Swap button when expanded */}
                {isExpanded && swapButton && (
                    <div className="mt-3 flex justify-center">
                        {swapButton}
                    </div>
                )}
            </div>
        </div>
    );
}
