/*    */ package mzm.gsp.genderconvert;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SGenderConvertSuccess
/*    */   extends __SGenderConvertSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12634371;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 15 */     return 12634371;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*    */   {
/* 27 */     return paramOctetsStream;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*    */     throws MarshalException
/*    */   {
/* 33 */     if (!_validator_()) {
/* 34 */       throw new VerifyError("validator failed");
/*    */     }
/* 36 */     return paramOctetsStream;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/* 41 */     if (paramObject == this) {
/* 42 */       return true;
/*    */     }
/* 44 */     if ((paramObject instanceof SGenderConvertSuccess)) {
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 52 */     int i = 0;
/* 53 */     return i;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 58 */     StringBuilder localStringBuilder = new StringBuilder();
/* 59 */     localStringBuilder.append("(");
/* 60 */     localStringBuilder.append(")");
/* 61 */     return localStringBuilder.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGenderConvertSuccess paramSGenderConvertSuccess)
/*    */   {
/* 66 */     if (paramSGenderConvertSuccess == this) {
/* 67 */       return 0;
/*    */     }
/* 69 */     int i = 0;
/* 70 */     return i;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\SGenderConvertSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */