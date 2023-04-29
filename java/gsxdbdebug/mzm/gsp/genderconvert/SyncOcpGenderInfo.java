/*     */ package mzm.gsp.genderconvert;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ public class SyncOcpGenderInfo
/*     */   extends __SyncOcpGenderInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12634372;
/*     */   public HashSet<OccpationInfo> occpations;
/*     */   public int last_convert_time;
/*     */   public byte is_guide_open;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  19 */     return 12634372;
/*     */   }
/*     */   
/*     */   public SyncOcpGenderInfo()
/*     */   {
/*  24 */     this.occpations = new HashSet();
/*     */   }
/*     */   
/*     */   public SyncOcpGenderInfo(HashSet<OccpationInfo> paramHashSet, int paramInt, byte paramByte)
/*     */   {
/*  29 */     this.occpations = paramHashSet;
/*  30 */     this.last_convert_time = paramInt;
/*  31 */     this.is_guide_open = paramByte;
/*     */   }
/*     */   
/*     */   public final boolean _validator_()
/*     */   {
/*  36 */     for (OccpationInfo localOccpationInfo : this.occpations) {
/*  37 */       if (!localOccpationInfo._validator_()) {
/*  38 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */   {
/*  47 */     paramOctetsStream.compact_uint32(this.occpations.size());
/*  48 */     for (OccpationInfo localOccpationInfo : this.occpations) {
/*  49 */       paramOctetsStream.marshal(localOccpationInfo);
/*     */     }
/*  51 */     paramOctetsStream.marshal(this.last_convert_time);
/*  52 */     paramOctetsStream.marshal(this.is_guide_open);
/*  53 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */     throws MarshalException
/*     */   {
/*  59 */     for (int i = paramOctetsStream.uncompact_uint32(); i > 0; i--)
/*     */     {
/*  61 */       OccpationInfo localOccpationInfo = new OccpationInfo();
/*  62 */       localOccpationInfo.unmarshal(paramOctetsStream);
/*  63 */       this.occpations.add(localOccpationInfo);
/*     */     }
/*  65 */     this.last_convert_time = paramOctetsStream.unmarshal_int();
/*  66 */     this.is_guide_open = paramOctetsStream.unmarshal_byte();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*  75 */     if (paramObject == this) {
/*  76 */       return true;
/*     */     }
/*  78 */     if ((paramObject instanceof SyncOcpGenderInfo))
/*     */     {
/*  80 */       SyncOcpGenderInfo localSyncOcpGenderInfo = (SyncOcpGenderInfo)paramObject;
/*  81 */       if (!this.occpations.equals(localSyncOcpGenderInfo.occpations)) {
/*  82 */         return false;
/*     */       }
/*  84 */       if (this.last_convert_time != localSyncOcpGenderInfo.last_convert_time) {
/*  85 */         return false;
/*     */       }
/*  87 */       if (this.is_guide_open != localSyncOcpGenderInfo.is_guide_open) {
/*  88 */         return false;
/*     */       }
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/*  97 */     int i = 0;
/*  98 */     i += this.occpations.hashCode();
/*  99 */     i += this.last_convert_time;
/* 100 */     i += this.is_guide_open;
/* 101 */     return i;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 106 */     StringBuilder localStringBuilder = new StringBuilder();
/* 107 */     localStringBuilder.append("(");
/* 108 */     localStringBuilder.append(this.occpations).append(",");
/* 109 */     localStringBuilder.append(this.last_convert_time).append(",");
/* 110 */     localStringBuilder.append(this.is_guide_open).append(",");
/* 111 */     localStringBuilder.append(")");
/* 112 */     return localStringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\SyncOcpGenderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */