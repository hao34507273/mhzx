/*     */ package mzm.gsp.ocpequip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.ocpequip.main.PPutOffOcpEquipReq;
/*     */ 
/*     */ public class CPutOffOcpEquipReq
/*     */   extends __CPutOffOcpEquipReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607747;
/*     */   public int ocp;
/*     */   public int gender;
/*     */   public int key;
/*     */   
/*     */   protected void process()
/*     */   {
/*  18 */     long l = Role.getRoleId(this);
/*  19 */     Role.addRoleProcedure(l, new PPutOffOcpEquipReq(l, this.ocp, this.gender, this.key));
/*     */   }
/*     */   
/*     */   public int getType()
/*     */   {
/*  24 */     return 12607747;
/*     */   }
/*     */   
/*     */   public CPutOffOcpEquipReq() {}
/*     */   
/*     */   public CPutOffOcpEquipReq(int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/*  31 */     this.ocp = paramInt1;
/*  32 */     this.gender = paramInt2;
/*  33 */     this.key = paramInt3;
/*     */   }
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */   {
/*  43 */     paramOctetsStream.marshal(this.ocp);
/*  44 */     paramOctetsStream.marshal(this.gender);
/*  45 */     paramOctetsStream.marshal(this.key);
/*  46 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */     throws MarshalException
/*     */   {
/*  52 */     this.ocp = paramOctetsStream.unmarshal_int();
/*  53 */     this.gender = paramOctetsStream.unmarshal_int();
/*  54 */     this.key = paramOctetsStream.unmarshal_int();
/*  55 */     if (!_validator_()) {
/*  56 */       throw new VerifyError("validator failed");
/*     */     }
/*  58 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*  63 */     if (paramObject == this) {
/*  64 */       return true;
/*     */     }
/*  66 */     if ((paramObject instanceof CPutOffOcpEquipReq))
/*     */     {
/*  68 */       CPutOffOcpEquipReq localCPutOffOcpEquipReq = (CPutOffOcpEquipReq)paramObject;
/*  69 */       if (this.ocp != localCPutOffOcpEquipReq.ocp) {
/*  70 */         return false;
/*     */       }
/*  72 */       if (this.gender != localCPutOffOcpEquipReq.gender) {
/*  73 */         return false;
/*     */       }
/*  75 */       if (this.key != localCPutOffOcpEquipReq.key) {
/*  76 */         return false;
/*     */       }
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/*  85 */     int i = 0;
/*  86 */     i += this.ocp;
/*  87 */     i += this.gender;
/*  88 */     i += this.key;
/*  89 */     return i;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*  94 */     StringBuilder localStringBuilder = new StringBuilder();
/*  95 */     localStringBuilder.append("(");
/*  96 */     localStringBuilder.append(this.ocp).append(",");
/*  97 */     localStringBuilder.append(this.gender).append(",");
/*  98 */     localStringBuilder.append(this.key).append(",");
/*  99 */     localStringBuilder.append(")");
/* 100 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CPutOffOcpEquipReq paramCPutOffOcpEquipReq)
/*     */   {
/* 105 */     if (paramCPutOffOcpEquipReq == this) {
/* 106 */       return 0;
/*     */     }
/* 108 */     int i = 0;
/* 109 */     i = this.ocp - paramCPutOffOcpEquipReq.ocp;
/* 110 */     if (0 != i) {
/* 111 */       return i;
/*     */     }
/* 113 */     i = this.gender - paramCPutOffOcpEquipReq.gender;
/* 114 */     if (0 != i) {
/* 115 */       return i;
/*     */     }
/* 117 */     i = this.key - paramCPutOffOcpEquipReq.key;
/* 118 */     if (0 != i) {
/* 119 */       return i;
/*     */     }
/* 121 */     return i;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\CPutOffOcpEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */