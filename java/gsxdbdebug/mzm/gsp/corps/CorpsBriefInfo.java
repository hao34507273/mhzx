/*    */ package mzm.gsp.corps;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class CorpsBriefInfo implements Marshal
/*    */ {
/*    */   public long corpsid;
/*    */   public Octets name;
/*    */   public Octets declaration;
/*    */   public int corpsbadgeid;
/*    */   public int createtime;
/*    */   
/*    */   public CorpsBriefInfo()
/*    */   {
/* 18 */     this.name = new Octets();
/* 19 */     this.declaration = new Octets();
/*    */   }
/*    */   
/*    */   public CorpsBriefInfo(long _corpsid_, Octets _name_, Octets _declaration_, int _corpsbadgeid_, int _createtime_) {
/* 23 */     this.corpsid = _corpsid_;
/* 24 */     this.name = _name_;
/* 25 */     this.declaration = _declaration_;
/* 26 */     this.corpsbadgeid = _corpsbadgeid_;
/* 27 */     this.createtime = _createtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.corpsid);
/* 36 */     _os_.marshal(this.name);
/* 37 */     _os_.marshal(this.declaration);
/* 38 */     _os_.marshal(this.corpsbadgeid);
/* 39 */     _os_.marshal(this.createtime);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     this.corpsid = _os_.unmarshal_long();
/* 45 */     this.name = _os_.unmarshal_Octets();
/* 46 */     this.declaration = _os_.unmarshal_Octets();
/* 47 */     this.corpsbadgeid = _os_.unmarshal_int();
/* 48 */     this.createtime = _os_.unmarshal_int();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof CorpsBriefInfo)) {
/* 55 */       CorpsBriefInfo _o_ = (CorpsBriefInfo)_o1_;
/* 56 */       if (this.corpsid != _o_.corpsid) return false;
/* 57 */       if (!this.name.equals(_o_.name)) return false;
/* 58 */       if (!this.declaration.equals(_o_.declaration)) return false;
/* 59 */       if (this.corpsbadgeid != _o_.corpsbadgeid) return false;
/* 60 */       if (this.createtime != _o_.createtime) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += (int)this.corpsid;
/* 69 */     _h_ += this.name.hashCode();
/* 70 */     _h_ += this.declaration.hashCode();
/* 71 */     _h_ += this.corpsbadgeid;
/* 72 */     _h_ += this.createtime;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.corpsid).append(",");
/* 80 */     _sb_.append("B").append(this.name.size()).append(",");
/* 81 */     _sb_.append("B").append(this.declaration.size()).append(",");
/* 82 */     _sb_.append(this.corpsbadgeid).append(",");
/* 83 */     _sb_.append(this.createtime).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CorpsBriefInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */