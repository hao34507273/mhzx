/*     */ package mzm.gsp.bounty;
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
/*     */ public class SBrocastBountyItem
/*     */   extends __SBrocastBountyItem__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584200;
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int taskid;
/*     */   public HashMap<Integer, Integer> itemid2count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584200;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBrocastBountyItem()
/*     */   {
/*  36 */     this.rolename = "";
/*  37 */     this.itemid2count = new HashMap();
/*     */   }
/*     */   
/*     */   public SBrocastBountyItem(long _roleid_, String _rolename_, int _taskid_, HashMap<Integer, Integer> _itemid2count_) {
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.rolename = _rolename_;
/*  43 */     this.taskid = _taskid_;
/*  44 */     this.itemid2count = _itemid2count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  54 */     _os_.marshal(this.taskid);
/*  55 */     _os_.compact_uint32(this.itemid2count.size());
/*  56 */     for (Map.Entry<Integer, Integer> _e_ : this.itemid2count.entrySet()) {
/*  57 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  58 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.roleid = _os_.unmarshal_long();
/*  65 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  66 */     this.taskid = _os_.unmarshal_int();
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.itemid2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SBrocastBountyItem)) {
/*  83 */       SBrocastBountyItem _o_ = (SBrocastBountyItem)_o1_;
/*  84 */       if (this.roleid != _o_.roleid) return false;
/*  85 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  86 */       if (this.taskid != _o_.taskid) return false;
/*  87 */       if (!this.itemid2count.equals(_o_.itemid2count)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += (int)this.roleid;
/*  96 */     _h_ += this.rolename.hashCode();
/*  97 */     _h_ += this.taskid;
/*  98 */     _h_ += this.itemid2count.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.roleid).append(",");
/* 106 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 107 */     _sb_.append(this.taskid).append(",");
/* 108 */     _sb_.append(this.itemid2count).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\SBrocastBountyItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */