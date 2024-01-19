package org.kwok.jwt;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.JsonWebKeySet;
import org.jose4j.jwk.VerificationJwkSelector;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.lang.JoseException;

/**
 * 生成 JWK：https://mkjwk.org/
 * 使用 JWK 生成 JWT：https://jwt.io/
 * JAVA 类库对 JWK 的支持：org.bitbucket.b_c:jose4j
 * jose4j 官方示例：https://bitbucket.org/b_c/jose4j/wiki/Home
 * @author: Kwok
 * @date: 2024/1/15
 */
public class Test_JWK {

    public static void main(String[] args) throws JoseException {

        // An example of signature verification using JSON Web Signature (JWS)
        // where the verification key is obtained from a JSON Web Key Set document.
        //

        // A JSON Web Key (JWK) is a JavaScript Object Notation (JSON) data structure that represents a
        // cryptographic key (often but not always a public key). A JSON Web Key Set (JWK Set) document
        // is a JSON data structure for representing one or more JSON Web Keys (JWK). A JWK Set might,
        // for example, be obtained from an HTTPS endpoint controlled by the signer but this example
        // presumes the JWK Set JSONhas already been acquired by some secure/trusted means.
        String jsonWebKeySetJson = "{\"keys\": [{\"kty\": \"RSA\", \"e\": \"AQAB\", \"use\": \"sig\", \"kid\": \"a24c2018-1880-4239-b470-1696976b4faf\", \"alg\": \"RS256\", \"n\": \"gi5P9-raQqw7SEnmU845hA0jcvV-c6dHChVYpdESb0Wp7xMIY_-LUhYw1gCbAXhdZGJ7H5fakCINloxxchjEA2IUEXgPiJa38RomHhh8NmO8uPSz_1jHGxxX4kz6elFfhO5g941HC0jy6ymCZutWJ8L4w1Yvx2mqwsWlC7ZpDoYu5TtGIY49I3Z-cXq2DK_pdsnNX3RXuPYnKScra2QXMm7ORGfENB5pQWSP7YQCGLweH8xrPOktFu1qe2nxD0420CAvz74jR8VoKF_6EheT9IGVy6ttRDrbZ3fBywgl36Jk1kq5PT27UTIsWl4cIEVcoYIKm1fJw8RxzJ9di1Bkbw\" } ] }";

        // The complete JWS representation, or compact serialization, is string consisting of
        // three dot ('.') separated base64url-encoded parts in the form Header.Payload.Signature
        String compactSerialization = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.eT6Y4Qa68MKdRpDqGt9ieNZqI1sKcu7QDV5yRLOVjEzH2375sH0y6kOzDPWi3Jx1DJIWkcHX-40SoiqukVJZlk3Gekh6b5mXbOW8W5xqN32ReG_g-fqno-ob5eINxy0BXR03Lw9EvbJ6uqzQZnM4-swGSniTBbaJsQM1U_M9DTswUwvmaV5dJCKb0miUfcE00mUaoIC9JMd0pGWio0UGai-nEo6ku6EvWB8stVvK_L74OpNFSJRmaVJoDZQtgXucHJh4Y__Xy54JkDozh6cNE_r36PsY0wYHkpgjtKnh6uwSHar7Nyhe2PRpKc08Ydu7j23VpN2gD9HB7egXEb___w";

        // Create a new JsonWebSignature object
        JsonWebSignature jws = new JsonWebSignature();

        // Set the algorithm constraints based on what is agreed upon or expected from the sender
        jws.setAlgorithmConstraints(new AlgorithmConstraints(AlgorithmConstraints.ConstraintType.PERMIT, AlgorithmIdentifiers.RSA_USING_SHA256));

        // Set the compact serialization on the JWS
        jws.setCompactSerialization(compactSerialization);

        // Create a new JsonWebKeySet object with the JWK Set JSON
        JsonWebKeySet jsonWebKeySet = new JsonWebKeySet(jsonWebKeySetJson);

        // The JWS header contains information indicating which key was used to secure the JWS.
        // In this case (as will hopefully often be the case) the JWS Key ID
        // corresponds directly to the Key ID in the JWK Set.
        // The VerificationJwkSelector looks at Key ID, Key Type, designated use (signatures vs. encryption),
        // and the designated algorithm in order to select the appropriate key for verification from
        // a set of JWKs.
        VerificationJwkSelector jwkSelector = new VerificationJwkSelector();
        JsonWebKey jwk = jwkSelector.select(jws, jsonWebKeySet.getJsonWebKeys());

        // The verification key on the JWS is the public key from the JWK we pulled from the JWK Set.
        // The verification key on the JWS is the public key from the JWK we pulled from the JWK Set.
        jws.setKey(jwk.getKey());

        // Check the signature
        boolean signatureVerified = jws.verifySignature();

        // Do something useful with the result of signature verification
        System.out.println("JWS Signature is valid: " + signatureVerified);

        // Get the payload, or signed content, from the JWS
        String payload = jws.getPayload();

        // Do something useful with the content
        System.out.println("JWS payload: " + payload);

    }

}
