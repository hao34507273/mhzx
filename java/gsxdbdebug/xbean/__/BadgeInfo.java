/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class BadgeInfo extends XBean implements xbean.BadgeInfo
/*     */ {
/*     */   private int badgeid;
/*     */   private long timelimit;
/*     */   private long sessionid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.badgeid = 0;
/*  23 */     this.timelimit = 0L;
/*  24 */     this.sessionid = 0L;
/*     */   }
/*     */   
/*     */   BadgeInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public BadgeInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public BadgeInfo(BadgeInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   BadgeInfo(xbean.BadgeInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof BadgeInfo)) { assign((BadgeInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(BadgeInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.badgeid = _o_.badgeid;
/*  55 */     this.timelimit = _o_.timelimit;
/*  56 */     this.sessionid = _o_.sessionid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.badgeid = _o_.badgeid;
/*  62 */     this.timelimit = _o_.timelimit;
/*  63 */     this.sessionid = _o_.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.badgeid);
/*  71 */     _os_.marshal(this.timelimit);
/*  72 */     _os_.marshal(this.sessionid);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.badgeid = _os_.unmarshal_int();
/*  81 */     this.timelimit = _os_.unmarshal_long();
/*  82 */     this.sessionid = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.badgeid);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.timelimit);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.sessionid);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.badgeid);
/* 104 */       _output_.writeInt64(2, this.timelimit);
/* 105 */       _output_.writeInt64(3, this.sessionid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.badgeid = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.timelimit = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.sessionid = _input_.readInt64();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BadgeInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new BadgeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BadgeInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BadgeInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new BadgeInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BadgeInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BadgeInfo toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getBadgeid()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.badgeid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTimelimit()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.timelimit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionid()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBadgeid(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "badgeid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, BadgeInfo.this.badgeid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             BadgeInfo.this.badgeid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.badgeid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTimelimit(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "timelimit")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogLong(this, BadgeInfo.this.timelimit)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             BadgeInfo.this.timelimit = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.timelimit = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionid(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "sessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogLong(this, BadgeInfo.this.sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             BadgeInfo.this.sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     BadgeInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof BadgeInfo)) { _o_ = (BadgeInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.badgeid != _o_.badgeid) return false;
/* 304 */     if (this.timelimit != _o_.timelimit) return false;
/* 305 */     if (this.sessionid != _o_.sessionid) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.badgeid;
/* 315 */     _h_ = (int)(_h_ + this.timelimit);
/* 316 */     _h_ = (int)(_h_ + this.sessionid);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.badgeid);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.timelimit);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.sessionid);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("badgeid"));
/* 340 */     lb.add(new ListenableChanged().setVarName("timelimit"));
/* 341 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.BadgeInfo {
/*     */     private Const() {}
/*     */     
/*     */     BadgeInfo nThis() {
/* 349 */       return BadgeInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BadgeInfo copy()
/*     */     {
/* 361 */       return BadgeInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BadgeInfo toData()
/*     */     {
/* 367 */       return BadgeInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.BadgeInfo toBean()
/*     */     {
/* 372 */       return BadgeInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BadgeInfo toDataIf()
/*     */     {
/* 378 */       return BadgeInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.BadgeInfo toBeanIf()
/*     */     {
/* 383 */       return BadgeInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBadgeid()
/*     */     {
/* 390 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 391 */       return BadgeInfo.this.badgeid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimelimit()
/*     */     {
/* 398 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 399 */       return BadgeInfo.this.timelimit;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 406 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 407 */       return BadgeInfo.this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBadgeid(int _v_)
/*     */     {
/* 414 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimelimit(long _v_)
/*     */     {
/* 422 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 430 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return BadgeInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return BadgeInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return BadgeInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return BadgeInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       BadgeInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return BadgeInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return BadgeInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return BadgeInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return BadgeInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return BadgeInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return BadgeInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return BadgeInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.BadgeInfo
/*     */   {
/*     */     private int badgeid;
/*     */     
/*     */     private long timelimit;
/*     */     
/*     */     private long sessionid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.BadgeInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof BadgeInfo)) { assign((BadgeInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof BadgeInfo.Const)) assign(((BadgeInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(BadgeInfo _o_) {
/* 558 */       this.badgeid = _o_.badgeid;
/* 559 */       this.timelimit = _o_.timelimit;
/* 560 */       this.sessionid = _o_.sessionid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.badgeid = _o_.badgeid;
/* 566 */       this.timelimit = _o_.timelimit;
/* 567 */       this.sessionid = _o_.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.badgeid);
/* 574 */       _os_.marshal(this.timelimit);
/* 575 */       _os_.marshal(this.sessionid);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.badgeid = _os_.unmarshal_int();
/* 583 */       this.timelimit = _os_.unmarshal_long();
/* 584 */       this.sessionid = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.badgeid);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.timelimit);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.sessionid);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.badgeid);
/* 604 */         _output_.writeInt64(2, this.timelimit);
/* 605 */         _output_.writeInt64(3, this.sessionid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.badgeid = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.timelimit = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.sessionid = _input_.readInt64();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BadgeInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BadgeInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.BadgeInfo toBean()
/*     */     {
/* 681 */       return new BadgeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BadgeInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.BadgeInfo toBeanIf()
/*     */     {
/* 692 */       return new BadgeInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBadgeid()
/*     */     {
/* 729 */       return this.badgeid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTimelimit()
/*     */     {
/* 736 */       return this.timelimit;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 743 */       return this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBadgeid(int _v_)
/*     */     {
/* 750 */       this.badgeid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTimelimit(long _v_)
/*     */     {
/* 757 */       this.timelimit = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 764 */       this.sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.badgeid != _o_.badgeid) return false;
/* 773 */       if (this.timelimit != _o_.timelimit) return false;
/* 774 */       if (this.sessionid != _o_.sessionid) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.badgeid;
/* 783 */       _h_ = (int)(_h_ + this.timelimit);
/* 784 */       _h_ = (int)(_h_ + this.sessionid);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.badgeid);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.timelimit);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.sessionid);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BadgeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */