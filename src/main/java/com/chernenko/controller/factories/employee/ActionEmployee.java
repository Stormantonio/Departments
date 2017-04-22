package com.chernenko.controller.factories.employee;

/**
 * Created by Anton on 16.04.2017.
 */
public enum ActionEmployee {

    createEmployee {
        public

        @Override
        String toString() {
            return "/createEmployee";
        }
    },

    editEmployee {
        public

        @Override
        String toString() {
            return "/editEmployee";
        }
    },

    listEmployees {
        public

        @Override
        String toString() {
            return "/listEmployees";
        }
    },

    deleteEmployee {
        public

        @Override
        String toString() {
            return "/deleteEmployee";
        }
    }
}
