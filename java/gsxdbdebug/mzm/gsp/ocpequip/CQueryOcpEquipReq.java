/*     */ package mzm.gsp.ocpequip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.ocpequip.main.PQueryOcpEquipReq;
/*     */ 
/*     */ public class CQueryOcpEquipReq
/*     */   extends __CQueryOcpEquipReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607751;
/*     */   public int ocp;
/*     */   public int gender;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     long l = Role.getRoleId(this);
/*  18 */     Role.addRoleProcedure(l, new PQueryOcpEquipReq(l, this.ocp, this.gender));
/*     */   }
/*     */   
/*     */   public int getType()
/*     */   {
/*  23 */     return 12607751;
/*     */   }
/*     */   
/*     */   public CQueryOcpEquipReq() {}
/*     */   
/*     */   public CQueryOcpEquipReq(int paramInt1, int paramInt2)
/*     */   {
/*  30 */     this.ocp = paramInt1;
/*  31 */     this.gender = paramInt2;
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
/*  43 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */     throws MarshalException
/*     */   {
/*  49 */     this.ocp = paramOctetsStream.unmarshal_int();
/*  50 */     this.gender = paramOctetsStream.unmarshal_int();
/*  51 */     if (!_validator_()) {
/*  52 */       throw new VerifyError("validator failed");
/*     */     }
/*  54 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*  59 */     if (paramObject == this) {
/*  60 */       return true;
/*     */     }
/*  62 */     if ((paramObject instanceof CQueryOcpEquipReq))
/*     */     {
/*  64 */       CQueryOcpEquipReq localCQueryOcpEquipReq = (CQueryOcpEquipReq)paramObject;
/*  65 */       if (this.ocp != localCQueryOcpEquipReq.ocp) {
/*  66 */         return false;
/*     */       }
/*  68 */       if (this.gender != localCQueryOcpEquipReq.gender) {
/*  69 */         return false;
/*     */       }
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/*  78 */     int i = 0;
/*  79 */     i += this.ocp;
/*  80 */     i += this.gender;
/*  81 */     return i;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*  86 */     StringBuilder localStringBuilder = new StringBuilder();
/*  87 */     localStringBuilder.append("(");
/*  88 */     localStringBuilder.append(this.ocp).append(",");
/*  89 */     localStringBuilder.append(this.gender).append(",");
/*  90 */     localStringBuilder.append(")");
/*  91 */     return localStringBuilder.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CQueryOcpEquipReq paramCQueryOcpEquipReq)
/*     */   {
/*  96 */     if (paramCQueryOcpEquipReq == this) {
/*  97 */       return 0;
/*     */     }
/*  99 */     int i = 0;
/* 100 */     i = this.ocp - paramCQueryOcpEquipReq.ocp;
/* 101 */     if (0 != i) {
/* 102 */       return i;
/*     */     }
/* 104 */     i = this.gender - paramCQueryOcpEquipReq.gender;
/* 105 */     if (0 != i) {
/* 106 */       return i;
/*     */     }
/* 108 */     return i;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\CQueryOcpEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */