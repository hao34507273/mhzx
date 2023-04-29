/*    */ package mzm.gsp.genderconvert;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SGenderConvertFailed
/*    */   extends __SGenderConvertFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12634369;
/*    */   public static final int ERROR_LEVEL = -1;
/*    */   public static final int ERROR_TEAM = -2;
/*    */   public static final int ERROR_MARRIED = -3;
/*    */   public static final int ERROR_CD = -4;
/*    */   public static final int ERROR_MONEY = -5;
/*    */   public static final int ERROR_SYSTEM = -6;
/*    */   public static final int ERROR_IN_COUPLING_CORPS = -7;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 23 */     return 12634369;
/*    */   }
/*    */   
/*    */   public SGenderConvertFailed() {}
/*    */   
/*    */   public SGenderConvertFailed(int paramInt)
/*    */   {
/* 30 */     this.retcode = paramInt;
/*    */   }
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*    */   {
/* 40 */     paramOctetsStream.marshal(this.retcode);
/* 41 */     return paramOctetsStream;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*    */     throws MarshalException
/*    */   {
/* 47 */     this.retcode = paramOctetsStream.unmarshal_int();
/* 48 */     if (!_validator_()) {
/* 49 */       throw new VerifyError("validator failed");
/*    */     }
/* 51 */     return paramOctetsStream;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/* 56 */     if (paramObject == this) {
/* 57 */       return true;
/*    */     }
/* 59 */     if ((paramObject instanceof SGenderConvertFailed))
/*    */     {
/* 61 */       SGenderConvertFailed localSGenderConvertFailed = (SGenderConvertFailed)paramObject;
/* 62 */       if (this.retcode != localSGenderConvertFailed.retcode) {
/* 63 */         return false;
/*    */       }
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 72 */     int i = 0;
/* 73 */     i += this.retcode;
/* 74 */     return i;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 79 */     StringBuilder localStringBuilder = new StringBuilder();
/* 80 */     localStringBuilder.append("(");
/* 81 */     localStringBuilder.append(this.retcode).append(",");
/* 82 */     localStringBuilder.append(")");
/* 83 */     return localStringBuilder.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGenderConvertFailed paramSGenderConvertFailed)
/*    */   {
/* 88 */     if (paramSGenderConvertFailed == this) {
/* 89 */       return 0;
/*    */     }
/* 91 */     int i = 0;
/* 92 */     i = this.retcode - paramSGenderConvertFailed.retcode;
/* 93 */     if (0 != i) {
/* 94 */       return i;
/*    */     }
/* 96 */     return i;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\SGenderConvertFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */