package com.chernenko.controller.factories.department;

/**
 * Created by Anton on 16.04.2017.
 */
public enum ActionDepartment {

    createDepartment {
        public
        @Override
        String toString() {
            return "/createDepartment";
        }
    },

    listDepartments {
        public

        @Override
        String toString() {
            return "/listDepartments";
        }
    },
    deleteDepartment {
        public

        @Override
        String toString() {
            return "/deleteDepartment";
        }
    }
}
