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
/*     */ public final class JinKu extends XBean implements xbean.JinKu
/*     */ {
/*     */   private int level;
/*     */   private long levelupendtime;
/*     */   private int gangmoney;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.level = 0;
/*  23 */     this.levelupendtime = 0L;
/*  24 */     this.gangmoney = 0;
/*     */   }
/*     */   
/*     */   JinKu(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public JinKu()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public JinKu(JinKu _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   JinKu(xbean.JinKu _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof JinKu)) { assign((JinKu)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(JinKu _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.level = _o_.level;
/*  55 */     this.levelupendtime = _o_.levelupendtime;
/*  56 */     this.gangmoney = _o_.gangmoney;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.level = _o_.level;
/*  62 */     this.levelupendtime = _o_.levelupendtime;
/*  63 */     this.gangmoney = _o_.gangmoney;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.level);
/*  71 */     _os_.marshal(this.levelupendtime);
/*  72 */     _os_.marshal(this.gangmoney);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.level = _os_.unmarshal_int();
/*  81 */     this.levelupendtime = _os_.unmarshal_long();
/*  82 */     this.gangmoney = _os_.unmarshal_int();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.levelupendtime);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(3, this.gangmoney);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.level);
/* 104 */       _output_.writeInt64(2, this.levelupendtime);
/* 105 */       _output_.writeInt32(3, this.gangmoney);
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
/* 133 */           this.level = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.levelupendtime = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.gangmoney = _input_.readInt32();
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
/*     */   public xbean.JinKu copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new JinKu(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JinKu toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JinKu toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new JinKu(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JinKu toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JinKu toBeanIf()
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
/*     */   public int getLevel()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLevelupendtime()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.levelupendtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGangmoney()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.gangmoney;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevel(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "level")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, JinKu.this.level)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             JinKu.this.level = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.level = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevelupendtime(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "levelupendtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogLong(this, JinKu.this.levelupendtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             JinKu.this.levelupendtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.levelupendtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGangmoney(int _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "gangmoney")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogInt(this, JinKu.this.gangmoney)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             JinKu.this.gangmoney = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.gangmoney = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     JinKu _o_ = null;
/* 300 */     if ((_o1_ instanceof JinKu)) { _o_ = (JinKu)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.level != _o_.level) return false;
/* 304 */     if (this.levelupendtime != _o_.levelupendtime) return false;
/* 305 */     if (this.gangmoney != _o_.gangmoney) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.level;
/* 315 */     _h_ = (int)(_h_ + this.levelupendtime);
/* 316 */     _h_ += this.gangmoney;
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.level);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.levelupendtime);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.gangmoney);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("level"));
/* 340 */     lb.add(new ListenableChanged().setVarName("levelupendtime"));
/* 341 */     lb.add(new ListenableChanged().setVarName("gangmoney"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.JinKu {
/*     */     private Const() {}
/*     */     
/*     */     JinKu nThis() {
/* 349 */       return JinKu.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JinKu copy()
/*     */     {
/* 361 */       return JinKu.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JinKu toData()
/*     */     {
/* 367 */       return JinKu.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.JinKu toBean()
/*     */     {
/* 372 */       return JinKu.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JinKu toDataIf()
/*     */     {
/* 378 */       return JinKu.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.JinKu toBeanIf()
/*     */     {
/* 383 */       return JinKu.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 390 */       JinKu.this._xdb_verify_unsafe_();
/* 391 */       return JinKu.this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLevelupendtime()
/*     */     {
/* 398 */       JinKu.this._xdb_verify_unsafe_();
/* 399 */       return JinKu.this.levelupendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGangmoney()
/*     */     {
/* 406 */       JinKu.this._xdb_verify_unsafe_();
/* 407 */       return JinKu.this.gangmoney;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 414 */       JinKu.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevelupendtime(long _v_)
/*     */     {
/* 422 */       JinKu.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGangmoney(int _v_)
/*     */     {
/* 430 */       JinKu.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       JinKu.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       JinKu.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return JinKu.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return JinKu.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       JinKu.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return JinKu.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return JinKu.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       JinKu.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return JinKu.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return JinKu.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return JinKu.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return JinKu.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return JinKu.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return JinKu.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return JinKu.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.JinKu
/*     */   {
/*     */     private int level;
/*     */     
/*     */     private long levelupendtime;
/*     */     
/*     */     private int gangmoney;
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
/*     */     Data(xbean.JinKu _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof JinKu)) { assign((JinKu)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof JinKu.Const)) assign(((JinKu.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(JinKu _o_) {
/* 558 */       this.level = _o_.level;
/* 559 */       this.levelupendtime = _o_.levelupendtime;
/* 560 */       this.gangmoney = _o_.gangmoney;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.level = _o_.level;
/* 566 */       this.levelupendtime = _o_.levelupendtime;
/* 567 */       this.gangmoney = _o_.gangmoney;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.level);
/* 574 */       _os_.marshal(this.levelupendtime);
/* 575 */       _os_.marshal(this.gangmoney);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.level = _os_.unmarshal_int();
/* 583 */       this.levelupendtime = _os_.unmarshal_long();
/* 584 */       this.gangmoney = _os_.unmarshal_int();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.levelupendtime);
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(3, this.gangmoney);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.level);
/* 604 */         _output_.writeInt64(2, this.levelupendtime);
/* 605 */         _output_.writeInt32(3, this.gangmoney);
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
/* 632 */             this.level = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.levelupendtime = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.gangmoney = _input_.readInt32();
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
/*     */     public xbean.JinKu copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JinKu toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.JinKu toBean()
/*     */     {
/* 681 */       return new JinKu(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JinKu toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.JinKu toBeanIf()
/*     */     {
/* 692 */       return new JinKu(this, null, null);
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
/*     */     public int getLevel()
/*     */     {
/* 729 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLevelupendtime()
/*     */     {
/* 736 */       return this.levelupendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGangmoney()
/*     */     {
/* 743 */       return this.gangmoney;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 750 */       this.level = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevelupendtime(long _v_)
/*     */     {
/* 757 */       this.levelupendtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGangmoney(int _v_)
/*     */     {
/* 764 */       this.gangmoney = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.level != _o_.level) return false;
/* 773 */       if (this.levelupendtime != _o_.levelupendtime) return false;
/* 774 */       if (this.gangmoney != _o_.gangmoney) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.level;
/* 783 */       _h_ = (int)(_h_ + this.levelupendtime);
/* 784 */       _h_ += this.gangmoney;
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.level);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.levelupendtime);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.gangmoney);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\JinKu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */