/*     */ package mzm.gsp.ocpequip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SPutOffOcpEquipRes
/*     */   extends __SPutOffOcpEquipRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607746;
/*     */   public int ocp;
/*     */   public int gender;
/*     */   public int key;
/*     */   public int itemid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  19 */     return 12607746;
/*     */   }
/*     */   
/*     */   public SPutOffOcpEquipRes() {}
/*     */   
/*     */   public SPutOffOcpEquipRes(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
/*     */   {
/*  26 */     this.ocp = paramInt1;
/*  27 */     this.gender = paramInt3;
/*  28 */     this.key = paramInt2;
/*  29 */     this.itemid = paramInt4;
/*     */   }
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */   {
/*  39 */     paramOctetsStream.marshal(this.ocp);
/*  40 */     paramOctetsStream.marshal(this.gender);
/*  41 */     paramOctetsStream.marshal(this.key);
/*  42 */     paramOctetsStream.marshal(this.itemid);
/*  43 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */     throws MarshalException
/*     */   {
/*  49 */     this.ocp = paramOctetsStream.unmarshal_int();
/*  50 */     this.gender = paramOctetsStream.unmarshal_int();
/*  51 */     this.key = paramOctetsStream.unmarshal_int();
/*  52 */     this.itemid = paramOctetsStream.unmarshal_int();
/*  53 */     if (!_validator_()) {
/*  54 */       throw new VerifyError("validator failed");
/*     */     }
/*  56 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*  61 */     if (paramObject == this) {
/*  62 */       return true;
/*     */     }
/*  64 */     if ((paramObject instanceof SPutOffOcpEquipRes))
/*     */     {
/*  66 */       SPutOffOcpEquipRes localSPutOffOcpEquipRes = (SPutOffOcpEquipRes)paramObject;
/*  67 */       if (this.ocp != localSPutOffOcpEquipRes.ocp) {
/*  68 */         return false;
/*     */       }
/*  70 */       if (this.gender != localSPutOffOcpEquipRes.gender) {
/*  71 */         return false;
/*     */       }
/*  73 */       if (this.key != localSPutOffOcpEquipRes.key) {
/*  74 */         return false;
/*     */       }
/*  76 */       if (this.itemid != localSPutOffOcpEquipRes.itemid) {
/*  77 */         return false;
/*     */       }
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/*  86 */     int i = 0;
/*  87 */     i += this.ocp;
/*  88 */     i += this.gender;
/*  89 */     i += this.key;
/*  90 */     i += this.itemid;
/*  91 */     return i;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*  96 */     StringBuilder localStringBuilder = new StringBuilder();
/*  97 */     localStringBuilder.append("(");
/*  98 */     localStringBuilder.append(this.ocp).append(",");
/*  99 */     localStringBuilder.append(this.gender).append(",");
/* 100 */     localStringBuilder.append(this.key).append(",");
/* 101 */     localStringBuilder.append(this.itemid).append(",");
/* 102 */     localStringBuilder.append(")");
/* 103 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SPutOffOcpEquipRes paramSPutOffOcpEquipRes)
/*     */   {
/* 108 */     if (paramSPutOffOcpEquipRes == this) {
/* 109 */       return 0;
/*     */     }
/* 111 */     int i = 0;
/* 112 */     i = this.ocp - paramSPutOffOcpEquipRes.ocp;
/* 113 */     if (0 != i) {
/* 114 */       return i;
/*     */     }
/* 116 */     i = this.gender - paramSPutOffOcpEquipRes.gender;
/* 117 */     if (0 != i) {
/* 118 */       return i;
/*     */     }
/* 120 */     i = this.key - paramSPutOffOcpEquipRes.key;
/* 121 */     if (0 != i) {
/* 122 */       return i;
/*     */     }
/* 124 */     i = this.itemid - paramSPutOffOcpEquipRes.itemid;
/* 125 */     if (0 != i) {
/* 126 */       return i;
/*     */     }
/* 128 */     return i;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\SPutOffOcpEquipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */