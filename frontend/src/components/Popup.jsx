import { useState } from "react";

export default function Popup() {
    const [show, setShow] = useState(() => {
        return !localStorage.getItem("popup_seen");
    });

    const handleClose = () => {
        localStorage.setItem("popup_seen", "true");
        setShow(false);
    };

    if (!show) return null;

    return (
        <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50" onClick={handleClose}>
            <div className="bg-white rounded-xl p-6 max-w-md mx-4 border border-gray-200" onClick={(e) => e.stopPropagation()}>
                <h2 className="text-base font-medium mb-3 text-gray-900">About this roadmap</h2>
                <p className="text-sm text-gray-600 leading-relaxed mb-3">
                    This roadmap is a general outline based on standard CSUN CS requirements —
                    not a 1-to-1 plan for every student.
                </p>
                <p className="text-sm text-gray-600 leading-relaxed mb-5">
                    Your actual path may vary based on transfer credits, AP scores, repeat courses,
                    and elective choices. Always verify your requirements with a counselor or your student DPR.
                </p>
                <button
                    onClick={handleClose}
                    className="w-full py-2 text-sm font-medium rounded-lg border-2 border-red-700 bg-white 
                    text-black hover:bg-red-700 hover:text-white transition-colors"
                >
                    Understood
                </button>
            </div>
        </div>
    );
}