/*     */ package mzm.gsp.ocpequip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.item.BagInfo;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ public class SSynOcpEquipRes
/*     */   extends __SSynOcpEquipRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607745;
/*     */   public int ocp;
/*     */   public int gender;
/*     */   public BagInfo ocpequipbags;
/*     */   public ModelInfo modelinfo;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  21 */     return 12607745;
/*     */   }
/*     */   
/*     */   public SSynOcpEquipRes()
/*     */   {
/*  26 */     this.ocpequipbags = new BagInfo();
/*  27 */     this.modelinfo = new ModelInfo();
/*     */   }
/*     */   
/*     */   public SSynOcpEquipRes(int paramInt1, int paramInt2, BagInfo paramBagInfo, ModelInfo paramModelInfo)
/*     */   {
/*  32 */     this.ocp = paramInt1;
/*  33 */     this.gender = paramInt2;
/*  34 */     this.ocpequipbags = paramBagInfo;
/*  35 */     this.modelinfo = paramModelInfo;
/*     */   }
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  40 */     if (!this.ocpequipbags._validator_()) {
/*  41 */       return false;
/*     */     }
/*  43 */     if (!this.modelinfo._validator_()) {
/*  44 */       return false;
/*     */     }
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */   {
/*  51 */     paramOctetsStream.marshal(this.ocp);
/*  52 */     paramOctetsStream.marshal(this.gender);
/*  53 */     paramOctetsStream.marshal(this.ocpequipbags);
/*  54 */     paramOctetsStream.marshal(this.modelinfo);
/*  55 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */     throws MarshalException
/*     */   {
/*  61 */     this.ocp = paramOctetsStream.unmarshal_int();
/*  62 */     this.gender = paramOctetsStream.unmarshal_int();
/*  63 */     this.ocpequipbags.unmarshal(paramOctetsStream);
/*  64 */     this.modelinfo.unmarshal(paramOctetsStream);
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*  73 */     if (paramObject == this) {
/*  74 */       return true;
/*     */     }
/*  76 */     if ((paramObject instanceof SSynOcpEquipRes))
/*     */     {
/*  78 */       SSynOcpEquipRes localSSynOcpEquipRes = (SSynOcpEquipRes)paramObject;
/*  79 */       if (this.ocp != localSSynOcpEquipRes.ocp) {
/*  80 */         return false;
/*     */       }
/*  82 */       if (this.gender != localSSynOcpEquipRes.gender) {
/*  83 */         return false;
/*     */       }
/*  85 */       if (!this.ocpequipbags.equals(localSSynOcpEquipRes.ocpequipbags)) {
/*  86 */         return false;
/*     */       }
/*  88 */       if (!this.modelinfo.equals(localSSynOcpEquipRes.modelinfo)) {
/*  89 */         return false;
/*     */       }
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/*  98 */     int i = 0;
/*  99 */     i += this.ocp;
/* 100 */     i += this.gender;
/* 101 */     i += this.ocpequipbags.hashCode();
/* 102 */     i += this.modelinfo.hashCode();
/* 103 */     return i;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 108 */     StringBuilder localStringBuilder = new StringBuilder();
/* 109 */     localStringBuilder.append("(");
/* 110 */     localStringBuilder.append(this.ocp).append(",");
/* 111 */     localStringBuilder.append(this.gender).append(",");
/* 112 */     localStringBuilder.append(this.ocpequipbags).append(",");
/* 113 */     localStringBuilder.append(this.modelinfo).append(",");
/* 114 */     localStringBuilder.append(")");
/* 115 */     return localStringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\SSynOcpEquipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */