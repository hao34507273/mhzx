/*     */ package mzm.gsp.qmhw;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBrocastQMHWItem
/*     */   extends __SBrocastQMHWItem__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601871;
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public HashMap<Integer, Integer> item2count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12601871;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBrocastQMHWItem()
/*     */   {
/*  35 */     this.rolename = "";
/*  36 */     this.item2count = new HashMap();
/*     */   }
/*     */   
/*     */   public SBrocastQMHWItem(long _roleid_, String _rolename_, HashMap<Integer, Integer> _item2count_) {
/*  40 */     this.roleid = _roleid_;
/*  41 */     this.rolename = _rolename_;
/*  42 */     this.item2count = _item2count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.roleid);
/*  51 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  52 */     _os_.compact_uint32(this.item2count.size());
/*  53 */     for (Map.Entry<Integer, Integer> _e_ : this.item2count.entrySet()) {
/*  54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  55 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.roleid = _os_.unmarshal_long();
/*  62 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  63 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  65 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.item2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SBrocastQMHWItem)) {
/*  79 */       SBrocastQMHWItem _o_ = (SBrocastQMHWItem)_o1_;
/*  80 */       if (this.roleid != _o_.roleid) return false;
/*  81 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  82 */       if (!this.item2count.equals(_o_.item2count)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.roleid;
/*  91 */     _h_ += this.rolename.hashCode();
/*  92 */     _h_ += this.item2count.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.roleid).append(",");
/* 100 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 101 */     _sb_.append(this.item2count).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\SBrocastQMHWItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */