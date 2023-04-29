/*    */ package mzm.gsp.genderconvert;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class OccpationInfo
/*    */   implements Marshal
/*    */ {
/*    */   public int occupation;
/*    */   public int gender;
/*    */   
/*    */   public OccpationInfo() {}
/*    */   
/*    */   public OccpationInfo(int paramInt1, int paramInt2)
/*    */   {
/* 18 */     this.occupation = paramInt1;
/* 19 */     this.gender = paramInt2;
/*    */   }
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*    */   {
/* 29 */     paramOctetsStream.marshal(this.occupation);
/* 30 */     paramOctetsStream.marshal(this.gender);
/* 31 */     return paramOctetsStream;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*    */     throws MarshalException
/*    */   {
/* 37 */     this.occupation = paramOctetsStream.unmarshal_int();
/* 38 */     this.gender = paramOctetsStream.unmarshal_int();
/* 39 */     return paramOctetsStream;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/* 44 */     if (paramObject == this) {
/* 45 */       return true;
/*    */     }
/* 47 */     if ((paramObject instanceof OccpationInfo))
/*    */     {
/* 49 */       OccpationInfo localOccpationInfo = (OccpationInfo)paramObject;
/* 50 */       if (this.occupation != localOccpationInfo.occupation) {
/* 51 */         return false;
/*    */       }
/* 53 */       if (this.gender != localOccpationInfo.gender) {
/* 54 */         return false;
/*    */       }
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 63 */     int i = 0;
/* 64 */     i += this.occupation;
/* 65 */     i += this.gender;
/* 66 */     return i;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 71 */     StringBuilder localStringBuilder = new StringBuilder();
/* 72 */     localStringBuilder.append("(");
/* 73 */     localStringBuilder.append(this.occupation).append(",");
/* 74 */     localStringBuilder.append(this.gender).append(",");
/* 75 */     localStringBuilder.append(")");
/* 76 */     return localStringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\OccpationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */