/*    */ package mzm.gsp.hula;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class MonsterInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int monsterid;
/*    */   public int state;
/*    */   public int seq;
/*    */   public Octets content;
/*    */   
/*    */   public MonsterInfo()
/*    */   {
/* 15 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public MonsterInfo(int _monsterid_, int _state_, int _seq_, Octets _content_) {
/* 19 */     this.monsterid = _monsterid_;
/* 20 */     this.state = _state_;
/* 21 */     this.seq = _seq_;
/* 22 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.monsterid);
/* 31 */     _os_.marshal(this.state);
/* 32 */     _os_.marshal(this.seq);
/* 33 */     _os_.marshal(this.content);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.monsterid = _os_.unmarshal_int();
/* 39 */     this.state = _os_.unmarshal_int();
/* 40 */     this.seq = _os_.unmarshal_int();
/* 41 */     this.content = _os_.unmarshal_Octets();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof MonsterInfo)) {
/* 48 */       MonsterInfo _o_ = (MonsterInfo)_o1_;
/* 49 */       if (this.monsterid != _o_.monsterid) return false;
/* 50 */       if (this.state != _o_.state) return false;
/* 51 */       if (this.seq != _o_.seq) return false;
/* 52 */       if (!this.content.equals(_o_.content)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.monsterid;
/* 61 */     _h_ += this.state;
/* 62 */     _h_ += this.seq;
/* 63 */     _h_ += this.content.hashCode();
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.monsterid).append(",");
/* 71 */     _sb_.append(this.state).append(",");
/* 72 */     _sb_.append(this.seq).append(",");
/* 73 */     _sb_.append("B").append(this.content.size()).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\MonsterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */