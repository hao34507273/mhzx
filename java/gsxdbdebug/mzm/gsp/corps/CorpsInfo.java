/*    */ package mzm.gsp.corps;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class CorpsInfo implements Marshal
/*    */ {
/*    */   public CorpsBriefInfo corpsbriefinfo;
/*    */   public HashMap<Long, CorpsMember> members;
/*    */   
/*    */   public CorpsInfo()
/*    */   {
/* 15 */     this.corpsbriefinfo = new CorpsBriefInfo();
/* 16 */     this.members = new HashMap();
/*    */   }
/*    */   
/*    */   public CorpsInfo(CorpsBriefInfo _corpsbriefinfo_, HashMap<Long, CorpsMember> _members_) {
/* 20 */     this.corpsbriefinfo = _corpsbriefinfo_;
/* 21 */     this.members = _members_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     if (!this.corpsbriefinfo._validator_()) return false;
/* 26 */     for (Map.Entry<Long, CorpsMember> _e_ : this.members.entrySet()) {
/* 27 */       if (!((CorpsMember)_e_.getValue())._validator_()) return false;
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.corpsbriefinfo);
/* 34 */     _os_.compact_uint32(this.members.size());
/* 35 */     for (Map.Entry<Long, CorpsMember> _e_ : this.members.entrySet()) {
/* 36 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 37 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 43 */     this.corpsbriefinfo.unmarshal(_os_);
/* 44 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 46 */       long _k_ = _os_.unmarshal_long();
/* 47 */       CorpsMember _v_ = new CorpsMember();
/* 48 */       _v_.unmarshal(_os_);
/* 49 */       this.members.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof CorpsInfo)) {
/* 57 */       CorpsInfo _o_ = (CorpsInfo)_o1_;
/* 58 */       if (!this.corpsbriefinfo.equals(_o_.corpsbriefinfo)) return false;
/* 59 */       if (!this.members.equals(_o_.members)) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.corpsbriefinfo.hashCode();
/* 68 */     _h_ += this.members.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.corpsbriefinfo).append(",");
/* 76 */     _sb_.append(this.members).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */