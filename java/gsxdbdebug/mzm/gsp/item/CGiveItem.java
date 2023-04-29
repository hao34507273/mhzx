/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PGiveItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGiveItem
/*     */   extends __CGiveItem__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584755;
/*     */   public long roleid;
/*     */   public HashMap<Long, Integer> uuid2num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  23 */     long selfRoleid = Role.getRoleId(this);
/*  24 */     Role.addRoleProcedure(selfRoleid, new PGiveItem(selfRoleid, this.roleid, this.uuid2num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12584755;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGiveItem()
/*     */   {
/*  40 */     this.uuid2num = new HashMap();
/*     */   }
/*     */   
/*     */   public CGiveItem(long _roleid_, HashMap<Long, Integer> _uuid2num_) {
/*  44 */     this.roleid = _roleid_;
/*  45 */     this.uuid2num = _uuid2num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.roleid);
/*  54 */     _os_.compact_uint32(this.uuid2num.size());
/*  55 */     for (Map.Entry<Long, Integer> _e_ : this.uuid2num.entrySet()) {
/*  56 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  57 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.roleid = _os_.unmarshal_long();
/*  64 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  66 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  68 */       int _v_ = _os_.unmarshal_int();
/*  69 */       this.uuid2num.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof CGiveItem)) {
/*  80 */       CGiveItem _o_ = (CGiveItem)_o1_;
/*  81 */       if (this.roleid != _o_.roleid) return false;
/*  82 */       if (!this.uuid2num.equals(_o_.uuid2num)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.roleid;
/*  91 */     _h_ += this.uuid2num.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.roleid).append(",");
/*  99 */     _sb_.append(this.uuid2num).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CGiveItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */