/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class sworninfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public long swornid;
/*    */   public String name1;
/*    */   public String name2;
/*    */   public ArrayList<memberinfo> members;
/*    */   
/*    */   public sworninfo()
/*    */   {
/* 15 */     this.name1 = "";
/* 16 */     this.name2 = "";
/* 17 */     this.members = new ArrayList();
/*    */   }
/*    */   
/*    */   public sworninfo(long _swornid_, String _name1_, String _name2_, ArrayList<memberinfo> _members_) {
/* 21 */     this.swornid = _swornid_;
/* 22 */     this.name1 = _name1_;
/* 23 */     this.name2 = _name2_;
/* 24 */     this.members = _members_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     for (memberinfo _v_ : this.members)
/* 29 */       if (!_v_._validator_()) return false;
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.swornid);
/* 35 */     _os_.marshal(this.name1, "UTF-16LE");
/* 36 */     _os_.marshal(this.name2, "UTF-16LE");
/* 37 */     _os_.compact_uint32(this.members.size());
/* 38 */     for (memberinfo _v_ : this.members) {
/* 39 */       _os_.marshal(_v_);
/*    */     }
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 45 */     this.swornid = _os_.unmarshal_long();
/* 46 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/* 47 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/* 48 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 49 */       memberinfo _v_ = new memberinfo();
/* 50 */       _v_.unmarshal(_os_);
/* 51 */       this.members.add(_v_);
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof sworninfo)) {
/* 59 */       sworninfo _o_ = (sworninfo)_o1_;
/* 60 */       if (this.swornid != _o_.swornid) return false;
/* 61 */       if (!this.name1.equals(_o_.name1)) return false;
/* 62 */       if (!this.name2.equals(_o_.name2)) return false;
/* 63 */       if (!this.members.equals(_o_.members)) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.swornid;
/* 72 */     _h_ += this.name1.hashCode();
/* 73 */     _h_ += this.name2.hashCode();
/* 74 */     _h_ += this.members.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.swornid).append(",");
/* 82 */     _sb_.append("T").append(this.name1.length()).append(",");
/* 83 */     _sb_.append("T").append(this.name2.length()).append(",");
/* 84 */     _sb_.append(this.members).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\sworninfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */