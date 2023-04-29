/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class CrossToken extends XBean implements xbean.CrossToken
/*     */ {
/*     */   private int zoneid;
/*     */   private byte[] token;
/*     */   private long roleid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.zoneid = 0;
/*  23 */     this.token = new byte[0];
/*  24 */     this.roleid = 0L;
/*     */   }
/*     */   
/*     */   CrossToken(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.token = new byte[0];
/*     */   }
/*     */   
/*     */   public CrossToken()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossToken(CrossToken _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossToken(xbean.CrossToken _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof CrossToken)) { assign((CrossToken)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossToken _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.zoneid = _o_.zoneid;
/*  56 */     this.token = Arrays.copyOf(_o_.token, _o_.token.length);
/*  57 */     this.roleid = _o_.roleid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.zoneid = _o_.zoneid;
/*  63 */     this.token = Arrays.copyOf(_o_.token, _o_.token.length);
/*  64 */     this.roleid = _o_.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.zoneid);
/*  72 */     _os_.marshal(this.token);
/*  73 */     _os_.marshal(this.roleid);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.zoneid = _os_.unmarshal_int();
/*  82 */     this.token = _os_.unmarshal_bytes();
/*  83 */     this.roleid = _os_.unmarshal_long();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(1, this.zoneid);
/*  93 */     _size_ += CodedOutputStream.computeByteArraySize(2, this.token);
/*  94 */     _size_ += CodedOutputStream.computeInt64Size(3, this.roleid);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt32(1, this.zoneid);
/* 105 */       _output_.writeByteArray(2, this.token);
/* 106 */       _output_.writeInt64(3, this.roleid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.zoneid = _input_.readInt32();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 139 */           this.token = _input_.readByteArray();
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 144 */           this.roleid = _input_.readInt64();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossToken copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new CrossToken(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossToken toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossToken toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new CrossToken(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossToken toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossToken toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getZoneid()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.zoneid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public <T extends Marshal> T getToken(T _v_)
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 224 */       _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.token)));
/* 225 */       return _v_;
/*     */     }
/*     */     catch (MarshalException _e_)
/*     */     {
/* 229 */       throw new xio.MarshalError();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isTokenEmpty()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     return this.token.length == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public byte[] getTokenCopy()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return Arrays.copyOf(this.token, this.token.length);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setZoneid(int _v_)
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     xdb.Logs.logIf(new LogKey(this, "zoneid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 266 */         new xdb.logs.LogInt(this, CrossToken.this.zoneid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 270 */             CrossToken.this.zoneid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 274 */     });
/* 275 */     this.zoneid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setToken(Marshal _v_)
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     xdb.Logs.logIf(new LogKey(this, "token")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 287 */         new xdb.logs.LogObject(this, CrossToken.this.token)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 291 */             CrossToken.this.token = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 295 */     });
/* 296 */     this.token = _v_.marshal(new OctetsStream()).getBytes();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTokenCopy(byte[] _v_)
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     xdb.Logs.logIf(new LogKey(this, "token")
/*     */     {
/*     */       protected xdb.Log create() {
/* 307 */         new xdb.logs.LogObject(this, CrossToken.this.token)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 311 */             CrossToken.this.token = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 315 */     });
/* 316 */     this.token = Arrays.copyOf(_v_, _v_.length);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 328 */         new xdb.logs.LogLong(this, CrossToken.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 332 */             CrossToken.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 336 */     });
/* 337 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     CrossToken _o_ = null;
/* 345 */     if ((_o1_ instanceof CrossToken)) { _o_ = (CrossToken)_o1_;
/* 346 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 347 */       return false;
/* 348 */     if (this.zoneid != _o_.zoneid) return false;
/* 349 */     if (!Arrays.equals(this.token, _o_.token)) return false;
/* 350 */     if (this.roleid != _o_.roleid) return false;
/* 351 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     int _h_ = 0;
/* 359 */     _h_ += this.zoneid;
/* 360 */     _h_ += Arrays.hashCode(this.token);
/* 361 */     _h_ = (int)(_h_ + this.roleid);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.zoneid);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append('B').append(this.token.length);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.roleid);
/* 376 */     _sb_.append(")");
/* 377 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 383 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 384 */     lb.add(new xdb.logs.ListenableChanged().setVarName("zoneid"));
/* 385 */     lb.add(new xdb.logs.ListenableChanged().setVarName("token"));
/* 386 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleid"));
/* 387 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossToken {
/*     */     private Const() {}
/*     */     
/*     */     CrossToken nThis() {
/* 394 */       return CrossToken.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossToken copy()
/*     */     {
/* 406 */       return CrossToken.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossToken toData()
/*     */     {
/* 412 */       return CrossToken.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossToken toBean()
/*     */     {
/* 417 */       return CrossToken.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossToken toDataIf()
/*     */     {
/* 423 */       return CrossToken.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossToken toBeanIf()
/*     */     {
/* 428 */       return CrossToken.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZoneid()
/*     */     {
/* 435 */       CrossToken.this._xdb_verify_unsafe_();
/* 436 */       return CrossToken.this.zoneid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getToken(T _v_)
/*     */     {
/* 443 */       CrossToken.this._xdb_verify_unsafe_();
/* 444 */       return CrossToken.this.getToken(_v_);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isTokenEmpty()
/*     */     {
/* 451 */       CrossToken.this._xdb_verify_unsafe_();
/* 452 */       return CrossToken.this.isTokenEmpty();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getTokenCopy()
/*     */     {
/* 459 */       CrossToken.this._xdb_verify_unsafe_();
/* 460 */       return CrossToken.this.getTokenCopy();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 467 */       CrossToken.this._xdb_verify_unsafe_();
/* 468 */       return CrossToken.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZoneid(int _v_)
/*     */     {
/* 475 */       CrossToken.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToken(Marshal _v_)
/*     */     {
/* 483 */       CrossToken.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTokenCopy(byte[] _v_)
/*     */     {
/* 491 */       CrossToken.this._xdb_verify_unsafe_();
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 499 */       CrossToken.this._xdb_verify_unsafe_();
/* 500 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 506 */       CrossToken.this._xdb_verify_unsafe_();
/* 507 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 513 */       CrossToken.this._xdb_verify_unsafe_();
/* 514 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 520 */       return CrossToken.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 526 */       return CrossToken.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws MarshalException
/*     */     {
/* 532 */       CrossToken.this._xdb_verify_unsafe_();
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 539 */       return CrossToken.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 545 */       return CrossToken.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 551 */       CrossToken.this._xdb_verify_unsafe_();
/* 552 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 558 */       return CrossToken.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 564 */       return CrossToken.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 570 */       return CrossToken.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 576 */       return CrossToken.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 582 */       return CrossToken.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 588 */       return CrossToken.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 594 */       return CrossToken.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossToken
/*     */   {
/*     */     private int zoneid;
/*     */     
/*     */     private byte[] token;
/*     */     
/*     */     private long roleid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 610 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 615 */       this.token = new byte[0];
/*     */     }
/*     */     
/*     */     Data(xbean.CrossToken _o1_)
/*     */     {
/* 620 */       if ((_o1_ instanceof CrossToken)) { assign((CrossToken)_o1_);
/* 621 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 622 */       } else if ((_o1_ instanceof CrossToken.Const)) assign(((CrossToken.Const)_o1_).nThis()); else {
/* 623 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossToken _o_) {
/* 628 */       this.zoneid = _o_.zoneid;
/* 629 */       this.token = Arrays.copyOf(_o_.token, _o_.token.length);
/* 630 */       this.roleid = _o_.roleid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 635 */       this.zoneid = _o_.zoneid;
/* 636 */       this.token = Arrays.copyOf(_o_.token, _o_.token.length);
/* 637 */       this.roleid = _o_.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 643 */       _os_.marshal(this.zoneid);
/* 644 */       _os_.marshal(this.token);
/* 645 */       _os_.marshal(this.roleid);
/* 646 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws MarshalException
/*     */     {
/* 652 */       this.zoneid = _os_.unmarshal_int();
/* 653 */       this.token = _os_.unmarshal_bytes();
/* 654 */       this.roleid = _os_.unmarshal_long();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.zoneid);
/* 663 */       _size_ += CodedOutputStream.computeByteArraySize(2, this.token);
/* 664 */       _size_ += CodedOutputStream.computeInt64Size(3, this.roleid);
/* 665 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 673 */         _output_.writeInt32(1, this.zoneid);
/* 674 */         _output_.writeByteArray(2, this.token);
/* 675 */         _output_.writeInt64(3, this.roleid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 679 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 681 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 689 */         boolean done = false;
/* 690 */         while (!done)
/*     */         {
/* 692 */           int tag = _input_.readTag();
/* 693 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 697 */             done = true;
/* 698 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 702 */             this.zoneid = _input_.readInt32();
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 707 */             this.token = _input_.readByteArray();
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 712 */             this.roleid = _input_.readInt64();
/* 713 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 717 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 719 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 728 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 732 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 734 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossToken copy()
/*     */     {
/* 740 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossToken toData()
/*     */     {
/* 746 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossToken toBean()
/*     */     {
/* 751 */       return new CrossToken(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossToken toDataIf()
/*     */     {
/* 757 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossToken toBeanIf()
/*     */     {
/* 762 */       return new CrossToken(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 768 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 772 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 776 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 780 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 784 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 788 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 792 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getZoneid()
/*     */     {
/* 799 */       return this.zoneid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getToken(T _v_)
/*     */     {
/*     */       try
/*     */       {
/* 808 */         _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.token)));
/* 809 */         return _v_;
/*     */       }
/*     */       catch (MarshalException _e_)
/*     */       {
/* 813 */         throw new xio.MarshalError();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isTokenEmpty()
/*     */     {
/* 821 */       return this.token.length == 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getTokenCopy()
/*     */     {
/* 828 */       return Arrays.copyOf(this.token, this.token.length);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 835 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setZoneid(int _v_)
/*     */     {
/* 842 */       this.zoneid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setToken(Marshal _v_)
/*     */     {
/* 849 */       this.token = _v_.marshal(new OctetsStream()).getBytes();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTokenCopy(byte[] _v_)
/*     */     {
/* 856 */       this.token = Arrays.copyOf(_v_, _v_.length);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 863 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 869 */       if (!(_o1_ instanceof Data)) return false;
/* 870 */       Data _o_ = (Data)_o1_;
/* 871 */       if (this.zoneid != _o_.zoneid) return false;
/* 872 */       if (!Arrays.equals(this.token, _o_.token)) return false;
/* 873 */       if (this.roleid != _o_.roleid) return false;
/* 874 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 880 */       int _h_ = 0;
/* 881 */       _h_ += this.zoneid;
/* 882 */       _h_ += Arrays.hashCode(this.token);
/* 883 */       _h_ = (int)(_h_ + this.roleid);
/* 884 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 890 */       StringBuilder _sb_ = new StringBuilder();
/* 891 */       _sb_.append("(");
/* 892 */       _sb_.append(this.zoneid);
/* 893 */       _sb_.append(",");
/* 894 */       _sb_.append('B').append(this.token.length);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append(this.roleid);
/* 897 */       _sb_.append(")");
/* 898 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */