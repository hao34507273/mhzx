/*     */ package mzm.gsp.ocpequip;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ 
/*     */ public class SPutOnOcpEquipRes
/*     */   extends __SPutOnOcpEquipRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607750;
/*     */   public int ocp;
/*     */   public int gender;
/*     */   public int key;
/*     */   public ItemInfo item;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  20 */     return 12607750;
/*     */   }
/*     */   
/*     */   public SPutOnOcpEquipRes()
/*     */   {
/*  25 */     this.item = new ItemInfo();
/*     */   }
/*     */   
/*     */   public SPutOnOcpEquipRes(int paramInt1, int paramInt2, int paramInt3, ItemInfo paramItemInfo)
/*     */   {
/*  30 */     this.ocp = paramInt1;
/*  31 */     this.gender = paramInt2;
/*  32 */     this.key = paramInt3;
/*  33 */     this.item = paramItemInfo;
/*     */   }
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  38 */     if (!this.item._validator_()) {
/*  39 */       return false;
/*     */     }
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */   {
/*  46 */     paramOctetsStream.marshal(this.ocp);
/*  47 */     paramOctetsStream.marshal(this.gender);
/*  48 */     paramOctetsStream.marshal(this.key);
/*  49 */     paramOctetsStream.marshal(this.item);
/*  50 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */     throws MarshalException
/*     */   {
/*  56 */     this.ocp = paramOctetsStream.unmarshal_int();
/*  57 */     this.gender = paramOctetsStream.unmarshal_int();
/*  58 */     this.key = paramOctetsStream.unmarshal_int();
/*  59 */     this.item.unmarshal(paramOctetsStream);
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*  68 */     if (paramObject == this) {
/*  69 */       return true;
/*     */     }
/*  71 */     if ((paramObject instanceof SPutOnOcpEquipRes))
/*     */     {
/*  73 */       SPutOnOcpEquipRes localSPutOnOcpEquipRes = (SPutOnOcpEquipRes)paramObject;
/*  74 */       if (this.ocp != localSPutOnOcpEquipRes.ocp) {
/*  75 */         return false;
/*     */       }
/*  77 */       if (this.gender != localSPutOnOcpEquipRes.gender) {
/*  78 */         return false;
/*     */       }
/*  80 */       if (this.key != localSPutOnOcpEquipRes.key) {
/*  81 */         return false;
/*     */       }
/*  83 */       if (!this.item.equals(localSPutOnOcpEquipRes.item)) {
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
/*  97 */     i += this.item.hashCode();
/*  98 */     return i;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 103 */     StringBuilder localStringBuilder = new StringBuilder();
/* 104 */     localStringBuilder.append("(");
/* 105 */     localStringBuilder.append(this.ocp).append(",");
/* 106 */     localStringBuilder.append(this.gender).append(",");
/* 107 */     localStringBuilder.append(this.key).append(",");
/* 108 */     localStringBuilder.append(this.item).append(",");
/* 109 */     localStringBuilder.append(")");
/* 110 */     return localStringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\SPutOnOcpEquipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */