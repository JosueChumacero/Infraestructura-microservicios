/**
 * Facturación API
 * Api de Spring boot para modulo de facturación
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

/**
 * modelo que representa a factura
 */
export interface FacturaResponse { 
    /**
     * clave unica que representa la factura
     */
    id: number;
    /**
     * clave unica que representa el dueño de la factura
     */
    cliente: number;
    /**
     * numero de factura
     */
    numero: string;
    detail?: string;
    monto?: number;
}