/*     */ package mzm.gsp.ocpequip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class STransferStrengthFromOcpBagRes
/*     */   extends __STransferStrengthFromOcpBagRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607752;
/*     */   public int ocp;
/*     */   public int gender;
/*     */   public int key;
/*     */   public int itemid;
/*     */   public int strengthlevel;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  20 */     return 12607752;
/*     */   }
/*     */   
/*     */   public STransferStrengthFromOcpBagRes() {}
/*     */   
/*     */   public STransferStrengthFromOcpBagRes(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
/*     */   {
/*  27 */     this.ocp = paramInt1;
/*  28 */     this.gender = paramInt2;
/*  29 */     this.key = paramInt3;
/*  30 */     this.itemid = paramInt4;
/*  31 */     this.strengthlevel = paramInt5;
/*     */   }
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */   {
/*  41 */     paramOctetsStream.marshal(this.ocp);
/*  42 */     paramOctetsStream.marshal(this.gender);
/*  43 */     paramOctetsStream.marshal(this.key);
/*  44 */     paramOctetsStream.marshal(this.itemid);
/*  45 */     paramOctetsStream.marshal(this.strengthlevel);
/*  46 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */     throws MarshalException
/*     */   {
/*  52 */     this.ocp = paramOctetsStream.unmarshal_int();
/*  53 */     this.gender = paramOctetsStream.unmarshal_int();
/*  54 */     this.key = paramOctetsStream.unmarshal_int();
/*  55 */     this.itemid = paramOctetsStream.unmarshal_int();
/*  56 */     this.strengthlevel = paramOctetsStream.unmarshal_int();
/*  57 */     if (!_validator_()) {
/*  58 */       throw new VerifyError("validator failed");
/*     */     }
/*  60 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*  65 */     if (paramObject == this) {
/*  66 */       return true;
/*     */     }
/*  68 */     if ((paramObject instanceof STransferStrengthFromOcpBagRes))
/*     */     {
/*  70 */       STransferStrengthFromOcpBagRes localSTransferStrengthFromOcpBagRes = (STransferStrengthFromOcpBagRes)paramObject;
/*  71 */       if (this.ocp != localSTransferStrengthFromOcpBagRes.ocp) {
/*  72 */         return false;
/*     */       }
/*  74 */       if (this.gender != localSTransferStrengthFromOcpBagRes.gender) {
/*  75 */         return false;
/*     */       }
/*  77 */       if (this.key != localSTransferStrengthFromOcpBagRes.key) {
/*  78 */         return false;
/*     */       }
/*  80 */       if (this.itemid != localSTransferStrengthFromOcpBagRes.itemid) {
/*  81 */         return false;
/*     */       }
/*  83 */       if (this.strengthlevel != localSTransferStrengthFromOcpBagRes.strengthlevel) {
/*  84 */         return false;
/*     */       }
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/*  93 */     int i = 0;
/*  94 */     i += this.ocp;
/*  95 */     i += this.gender;
/*  96 */     i += this.key;
/*  97 */     i += this.itemid;
/*  98 */     i += this.strengthlevel;
/*  99 */     return i;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 104 */     StringBuilder localStringBuilder = new StringBuilder();
/* 105 */     localStringBuilder.append("(");
/* 106 */     localStringBuilder.append(this.ocp).append(",");
/* 107 */     localStringBuilder.append(this.gender).append(",");
/* 108 */     localStringBuilder.append(this.key).append(",");
/* 109 */     localStringBuilder.append(this.itemid).append(",");
/* 110 */     localStringBuilder.append(this.strengthlevel).append(",");
/* 111 */     localStringBuilder.append(")");
/* 112 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(STransferStrengthFromOcpBagRes paramSTransferStrengthFromOcpBagRes)
/*     */   {
/* 117 */     if (paramSTransferStrengthFromOcpBagRes == this) {
/* 118 */       return 0;
/*     */     }
/* 120 */     int i = 0;
/* 121 */     i = this.ocp - paramSTransferStrengthFromOcpBagRes.ocp;
/* 122 */     if (0 != i) {
/* 123 */       return i;
/*     */     }
/* 125 */     i = this.gender - paramSTransferStrengthFromOcpBagRes.gender;
/* 126 */     if (0 != i) {
/* 127 */       return i;
/*     */     }
/* 129 */     i = this.key - paramSTransferStrengthFromOcpBagRes.key;
/* 130 */     if (0 != i) {
/* 131 */       return i;
/*     */     }
/* 133 */     i = this.itemid - paramSTransferStrengthFromOcpBagRes.itemid;
/* 134 */     if (0 != i) {
/* 135 */       return i;
/*     */     }
/* 137 */     i = this.strengthlevel - paramSTransferStrengthFromOcpBagRes.strengthlevel;
/* 138 */     if (0 != i) {
/* 139 */       return i;
/*     */     }
/* 141 */     return i;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\STransferStrengthFromOcpBagRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */