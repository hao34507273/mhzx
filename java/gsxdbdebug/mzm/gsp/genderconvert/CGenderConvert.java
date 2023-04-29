/*    */ package mzm.gsp.genderconvert;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.genderconvert.main.PGenderConvert;
/*    */ 
/*    */ public class CGenderConvert
/*    */   extends __CGenderConvert__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12634370;
/*    */   
/*    */   protected void process()
/*    */   {
/* 15 */     long l = Role.getRoleId(this);
/* 16 */     Role.addRoleProcedure(l, new PGenderConvert(l));
/*    */   }
/*    */   
/*    */   public int getType()
/*    */   {
/* 21 */     return 12634370;
/*    */   }
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*    */   {
/* 31 */     return paramOctetsStream;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*    */     throws MarshalException
/*    */   {
/* 37 */     if (!_validator_()) {
/* 38 */       throw new VerifyError("validator failed");
/*    */     }
/* 40 */     return paramOctetsStream;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/* 45 */     if (paramObject == this) {
/* 46 */       return true;
/*    */     }
/* 48 */     if ((paramObject instanceof CGenderConvert)) {
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 56 */     int i = 0;
/* 57 */     return i;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 62 */     StringBuilder localStringBuilder = new StringBuilder();
/* 63 */     localStringBuilder.append("(");
/* 64 */     localStringBuilder.append(")");
/* 65 */     return localStringBuilder.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGenderConvert paramCGenderConvert)
/*    */   {
/* 70 */     if (paramCGenderConvert == this) {
/* 71 */       return 0;
/*    */     }
/* 73 */     int i = 0;
/* 74 */     return i;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\CGenderConvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */