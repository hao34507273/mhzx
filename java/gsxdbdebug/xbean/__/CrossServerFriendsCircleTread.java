/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogObject;
/*     */ 
/*     */ public final class CrossServerFriendsCircleTread extends XBean implements xbean.CrossServerFriendsCircleTread
/*     */ {
/*     */   private long be_trod_role_id;
/*     */   private int be_trod_role_zone_id;
/*     */   private boolean is_server_replied;
/*     */   private boolean is_can_get_more_treasure_box;
/*     */   private boolean is_auto_tread;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.be_trod_role_id = 0L;
/*  27 */     this.be_trod_role_zone_id = 0;
/*  28 */     this.is_server_replied = false;
/*  29 */     this.is_can_get_more_treasure_box = false;
/*  30 */     this.is_auto_tread = false;
/*     */   }
/*     */   
/*     */   CrossServerFriendsCircleTread(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public CrossServerFriendsCircleTread()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossServerFriendsCircleTread(CrossServerFriendsCircleTread _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossServerFriendsCircleTread(xbean.CrossServerFriendsCircleTread _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof CrossServerFriendsCircleTread)) { assign((CrossServerFriendsCircleTread)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossServerFriendsCircleTread _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.be_trod_role_id = _o_.be_trod_role_id;
/*  61 */     this.be_trod_role_zone_id = _o_.be_trod_role_zone_id;
/*  62 */     this.is_server_replied = _o_.is_server_replied;
/*  63 */     this.is_can_get_more_treasure_box = _o_.is_can_get_more_treasure_box;
/*  64 */     this.is_auto_tread = _o_.is_auto_tread;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.be_trod_role_id = _o_.be_trod_role_id;
/*  70 */     this.be_trod_role_zone_id = _o_.be_trod_role_zone_id;
/*  71 */     this.is_server_replied = _o_.is_server_replied;
/*  72 */     this.is_can_get_more_treasure_box = _o_.is_can_get_more_treasure_box;
/*  73 */     this.is_auto_tread = _o_.is_auto_tread;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.be_trod_role_id);
/*  81 */     _os_.marshal(this.be_trod_role_zone_id);
/*  82 */     _os_.marshal(this.is_server_replied);
/*  83 */     _os_.marshal(this.is_can_get_more_treasure_box);
/*  84 */     _os_.marshal(this.is_auto_tread);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.be_trod_role_id = _os_.unmarshal_long();
/*  93 */     this.be_trod_role_zone_id = _os_.unmarshal_int();
/*  94 */     this.is_server_replied = _os_.unmarshal_boolean();
/*  95 */     this.is_can_get_more_treasure_box = _os_.unmarshal_boolean();
/*  96 */     this.is_auto_tread = _os_.unmarshal_boolean();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt64Size(1, this.be_trod_role_id);
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(2, this.be_trod_role_zone_id);
/* 107 */     _size_ += CodedOutputStream.computeBoolSize(3, this.is_server_replied);
/* 108 */     _size_ += CodedOutputStream.computeBoolSize(4, this.is_can_get_more_treasure_box);
/* 109 */     _size_ += CodedOutputStream.computeBoolSize(5, this.is_auto_tread);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt64(1, this.be_trod_role_id);
/* 120 */       _output_.writeInt32(2, this.be_trod_role_zone_id);
/* 121 */       _output_.writeBool(3, this.is_server_replied);
/* 122 */       _output_.writeBool(4, this.is_can_get_more_treasure_box);
/* 123 */       _output_.writeBool(5, this.is_auto_tread);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 127 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 129 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       boolean done = false;
/* 139 */       while (!done)
/*     */       {
/* 141 */         int tag = _input_.readTag();
/* 142 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 146 */           done = true;
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 151 */           this.be_trod_role_id = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           this.be_trod_role_zone_id = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 161 */           this.is_server_replied = _input_.readBool();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 166 */           this.is_can_get_more_treasure_box = _input_.readBool();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 171 */           this.is_auto_tread = _input_.readBool();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossServerFriendsCircleTread copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new CrossServerFriendsCircleTread(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossServerFriendsCircleTread toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossServerFriendsCircleTread toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new CrossServerFriendsCircleTread(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossServerFriendsCircleTread toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossServerFriendsCircleTread toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getBe_trod_role_id()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.be_trod_role_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getBe_trod_role_zone_id()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return this.be_trod_role_zone_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIs_server_replied()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     return this.is_server_replied;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIs_can_get_more_treasure_box()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     return this.is_can_get_more_treasure_box;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIs_auto_tread()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this.is_auto_tread;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBe_trod_role_id(long _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "be_trod_role_id")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 285 */         new xdb.logs.LogLong(this, CrossServerFriendsCircleTread.this.be_trod_role_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             CrossServerFriendsCircleTread.this.be_trod_role_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.be_trod_role_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBe_trod_role_zone_id(int _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "be_trod_role_zone_id")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 306 */         new xdb.logs.LogInt(this, CrossServerFriendsCircleTread.this.be_trod_role_zone_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             CrossServerFriendsCircleTread.this.be_trod_role_zone_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.be_trod_role_zone_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIs_server_replied(boolean _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "is_server_replied")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 327 */         new LogObject(this, Boolean.valueOf(CrossServerFriendsCircleTread.this.is_server_replied))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             CrossServerFriendsCircleTread.this.is_server_replied = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.is_server_replied = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIs_can_get_more_treasure_box(boolean _v_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     xdb.Logs.logIf(new LogKey(this, "is_can_get_more_treasure_box")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 348 */         new LogObject(this, Boolean.valueOf(CrossServerFriendsCircleTread.this.is_can_get_more_treasure_box))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 352 */             CrossServerFriendsCircleTread.this.is_can_get_more_treasure_box = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 356 */     });
/* 357 */     this.is_can_get_more_treasure_box = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIs_auto_tread(boolean _v_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     xdb.Logs.logIf(new LogKey(this, "is_auto_tread")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 369 */         new LogObject(this, Boolean.valueOf(CrossServerFriendsCircleTread.this.is_auto_tread))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 373 */             CrossServerFriendsCircleTread.this.is_auto_tread = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 377 */     });
/* 378 */     this.is_auto_tread = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 384 */     _xdb_verify_unsafe_();
/* 385 */     CrossServerFriendsCircleTread _o_ = null;
/* 386 */     if ((_o1_ instanceof CrossServerFriendsCircleTread)) { _o_ = (CrossServerFriendsCircleTread)_o1_;
/* 387 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 388 */       return false;
/* 389 */     if (this.be_trod_role_id != _o_.be_trod_role_id) return false;
/* 390 */     if (this.be_trod_role_zone_id != _o_.be_trod_role_zone_id) return false;
/* 391 */     if (this.is_server_replied != _o_.is_server_replied) return false;
/* 392 */     if (this.is_can_get_more_treasure_box != _o_.is_can_get_more_treasure_box) return false;
/* 393 */     if (this.is_auto_tread != _o_.is_auto_tread) return false;
/* 394 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 400 */     _xdb_verify_unsafe_();
/* 401 */     int _h_ = 0;
/* 402 */     _h_ = (int)(_h_ + this.be_trod_role_id);
/* 403 */     _h_ += this.be_trod_role_zone_id;
/* 404 */     _h_ += (this.is_server_replied ? 1231 : 1237);
/* 405 */     _h_ += (this.is_can_get_more_treasure_box ? 1231 : 1237);
/* 406 */     _h_ += (this.is_auto_tread ? 1231 : 1237);
/* 407 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 413 */     _xdb_verify_unsafe_();
/* 414 */     StringBuilder _sb_ = new StringBuilder();
/* 415 */     _sb_.append("(");
/* 416 */     _sb_.append(this.be_trod_role_id);
/* 417 */     _sb_.append(",");
/* 418 */     _sb_.append(this.be_trod_role_zone_id);
/* 419 */     _sb_.append(",");
/* 420 */     _sb_.append(this.is_server_replied);
/* 421 */     _sb_.append(",");
/* 422 */     _sb_.append(this.is_can_get_more_treasure_box);
/* 423 */     _sb_.append(",");
/* 424 */     _sb_.append(this.is_auto_tread);
/* 425 */     _sb_.append(")");
/* 426 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 432 */     ListenableBean lb = new ListenableBean();
/* 433 */     lb.add(new ListenableChanged().setVarName("be_trod_role_id"));
/* 434 */     lb.add(new ListenableChanged().setVarName("be_trod_role_zone_id"));
/* 435 */     lb.add(new ListenableChanged().setVarName("is_server_replied"));
/* 436 */     lb.add(new ListenableChanged().setVarName("is_can_get_more_treasure_box"));
/* 437 */     lb.add(new ListenableChanged().setVarName("is_auto_tread"));
/* 438 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossServerFriendsCircleTread {
/*     */     private Const() {}
/*     */     
/*     */     CrossServerFriendsCircleTread nThis() {
/* 445 */       return CrossServerFriendsCircleTread.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossServerFriendsCircleTread copy()
/*     */     {
/* 457 */       return CrossServerFriendsCircleTread.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossServerFriendsCircleTread toData()
/*     */     {
/* 463 */       return CrossServerFriendsCircleTread.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossServerFriendsCircleTread toBean()
/*     */     {
/* 468 */       return CrossServerFriendsCircleTread.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossServerFriendsCircleTread toDataIf()
/*     */     {
/* 474 */       return CrossServerFriendsCircleTread.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossServerFriendsCircleTread toBeanIf()
/*     */     {
/* 479 */       return CrossServerFriendsCircleTread.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBe_trod_role_id()
/*     */     {
/* 486 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 487 */       return CrossServerFriendsCircleTread.this.be_trod_role_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBe_trod_role_zone_id()
/*     */     {
/* 494 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 495 */       return CrossServerFriendsCircleTread.this.be_trod_role_zone_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_server_replied()
/*     */     {
/* 502 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 503 */       return CrossServerFriendsCircleTread.this.is_server_replied;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_can_get_more_treasure_box()
/*     */     {
/* 510 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 511 */       return CrossServerFriendsCircleTread.this.is_can_get_more_treasure_box;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_auto_tread()
/*     */     {
/* 518 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 519 */       return CrossServerFriendsCircleTread.this.is_auto_tread;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBe_trod_role_id(long _v_)
/*     */     {
/* 526 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBe_trod_role_zone_id(int _v_)
/*     */     {
/* 534 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_server_replied(boolean _v_)
/*     */     {
/* 542 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_can_get_more_treasure_box(boolean _v_)
/*     */     {
/* 550 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_auto_tread(boolean _v_)
/*     */     {
/* 558 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 565 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 566 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 572 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 573 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 579 */       return CrossServerFriendsCircleTread.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 585 */       return CrossServerFriendsCircleTread.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 591 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 598 */       return CrossServerFriendsCircleTread.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 604 */       return CrossServerFriendsCircleTread.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 610 */       CrossServerFriendsCircleTread.this._xdb_verify_unsafe_();
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 617 */       return CrossServerFriendsCircleTread.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       return CrossServerFriendsCircleTread.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 629 */       return CrossServerFriendsCircleTread.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 635 */       return CrossServerFriendsCircleTread.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 641 */       return CrossServerFriendsCircleTread.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 647 */       return CrossServerFriendsCircleTread.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 653 */       return CrossServerFriendsCircleTread.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossServerFriendsCircleTread
/*     */   {
/*     */     private long be_trod_role_id;
/*     */     
/*     */     private int be_trod_role_zone_id;
/*     */     
/*     */     private boolean is_server_replied;
/*     */     
/*     */     private boolean is_can_get_more_treasure_box;
/*     */     
/*     */     private boolean is_auto_tread;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 673 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.CrossServerFriendsCircleTread _o1_)
/*     */     {
/* 682 */       if ((_o1_ instanceof CrossServerFriendsCircleTread)) { assign((CrossServerFriendsCircleTread)_o1_);
/* 683 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 684 */       } else if ((_o1_ instanceof CrossServerFriendsCircleTread.Const)) assign(((CrossServerFriendsCircleTread.Const)_o1_).nThis()); else {
/* 685 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossServerFriendsCircleTread _o_) {
/* 690 */       this.be_trod_role_id = _o_.be_trod_role_id;
/* 691 */       this.be_trod_role_zone_id = _o_.be_trod_role_zone_id;
/* 692 */       this.is_server_replied = _o_.is_server_replied;
/* 693 */       this.is_can_get_more_treasure_box = _o_.is_can_get_more_treasure_box;
/* 694 */       this.is_auto_tread = _o_.is_auto_tread;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 699 */       this.be_trod_role_id = _o_.be_trod_role_id;
/* 700 */       this.be_trod_role_zone_id = _o_.be_trod_role_zone_id;
/* 701 */       this.is_server_replied = _o_.is_server_replied;
/* 702 */       this.is_can_get_more_treasure_box = _o_.is_can_get_more_treasure_box;
/* 703 */       this.is_auto_tread = _o_.is_auto_tread;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 709 */       _os_.marshal(this.be_trod_role_id);
/* 710 */       _os_.marshal(this.be_trod_role_zone_id);
/* 711 */       _os_.marshal(this.is_server_replied);
/* 712 */       _os_.marshal(this.is_can_get_more_treasure_box);
/* 713 */       _os_.marshal(this.is_auto_tread);
/* 714 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 720 */       this.be_trod_role_id = _os_.unmarshal_long();
/* 721 */       this.be_trod_role_zone_id = _os_.unmarshal_int();
/* 722 */       this.is_server_replied = _os_.unmarshal_boolean();
/* 723 */       this.is_can_get_more_treasure_box = _os_.unmarshal_boolean();
/* 724 */       this.is_auto_tread = _os_.unmarshal_boolean();
/* 725 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 731 */       int _size_ = 0;
/* 732 */       _size_ += CodedOutputStream.computeInt64Size(1, this.be_trod_role_id);
/* 733 */       _size_ += CodedOutputStream.computeInt32Size(2, this.be_trod_role_zone_id);
/* 734 */       _size_ += CodedOutputStream.computeBoolSize(3, this.is_server_replied);
/* 735 */       _size_ += CodedOutputStream.computeBoolSize(4, this.is_can_get_more_treasure_box);
/* 736 */       _size_ += CodedOutputStream.computeBoolSize(5, this.is_auto_tread);
/* 737 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 745 */         _output_.writeInt64(1, this.be_trod_role_id);
/* 746 */         _output_.writeInt32(2, this.be_trod_role_zone_id);
/* 747 */         _output_.writeBool(3, this.is_server_replied);
/* 748 */         _output_.writeBool(4, this.is_can_get_more_treasure_box);
/* 749 */         _output_.writeBool(5, this.is_auto_tread);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 753 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 755 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 763 */         boolean done = false;
/* 764 */         while (!done)
/*     */         {
/* 766 */           int tag = _input_.readTag();
/* 767 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 771 */             done = true;
/* 772 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 776 */             this.be_trod_role_id = _input_.readInt64();
/* 777 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 781 */             this.be_trod_role_zone_id = _input_.readInt32();
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 786 */             this.is_server_replied = _input_.readBool();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 791 */             this.is_can_get_more_treasure_box = _input_.readBool();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 796 */             this.is_auto_tread = _input_.readBool();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 801 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 803 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 812 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 816 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 818 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossServerFriendsCircleTread copy()
/*     */     {
/* 824 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossServerFriendsCircleTread toData()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossServerFriendsCircleTread toBean()
/*     */     {
/* 835 */       return new CrossServerFriendsCircleTread(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossServerFriendsCircleTread toDataIf()
/*     */     {
/* 841 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossServerFriendsCircleTread toBeanIf()
/*     */     {
/* 846 */       return new CrossServerFriendsCircleTread(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 852 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 872 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 876 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getBe_trod_role_id()
/*     */     {
/* 883 */       return this.be_trod_role_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBe_trod_role_zone_id()
/*     */     {
/* 890 */       return this.be_trod_role_zone_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_server_replied()
/*     */     {
/* 897 */       return this.is_server_replied;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_can_get_more_treasure_box()
/*     */     {
/* 904 */       return this.is_can_get_more_treasure_box;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIs_auto_tread()
/*     */     {
/* 911 */       return this.is_auto_tread;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBe_trod_role_id(long _v_)
/*     */     {
/* 918 */       this.be_trod_role_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBe_trod_role_zone_id(int _v_)
/*     */     {
/* 925 */       this.be_trod_role_zone_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_server_replied(boolean _v_)
/*     */     {
/* 932 */       this.is_server_replied = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_can_get_more_treasure_box(boolean _v_)
/*     */     {
/* 939 */       this.is_can_get_more_treasure_box = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIs_auto_tread(boolean _v_)
/*     */     {
/* 946 */       this.is_auto_tread = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 952 */       if (!(_o1_ instanceof Data)) return false;
/* 953 */       Data _o_ = (Data)_o1_;
/* 954 */       if (this.be_trod_role_id != _o_.be_trod_role_id) return false;
/* 955 */       if (this.be_trod_role_zone_id != _o_.be_trod_role_zone_id) return false;
/* 956 */       if (this.is_server_replied != _o_.is_server_replied) return false;
/* 957 */       if (this.is_can_get_more_treasure_box != _o_.is_can_get_more_treasure_box) return false;
/* 958 */       if (this.is_auto_tread != _o_.is_auto_tread) return false;
/* 959 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 965 */       int _h_ = 0;
/* 966 */       _h_ = (int)(_h_ + this.be_trod_role_id);
/* 967 */       _h_ += this.be_trod_role_zone_id;
/* 968 */       _h_ += (this.is_server_replied ? 1231 : 1237);
/* 969 */       _h_ += (this.is_can_get_more_treasure_box ? 1231 : 1237);
/* 970 */       _h_ += (this.is_auto_tread ? 1231 : 1237);
/* 971 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 977 */       StringBuilder _sb_ = new StringBuilder();
/* 978 */       _sb_.append("(");
/* 979 */       _sb_.append(this.be_trod_role_id);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.be_trod_role_zone_id);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append(this.is_server_replied);
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.is_can_get_more_treasure_box);
/* 986 */       _sb_.append(",");
/* 987 */       _sb_.append(this.is_auto_tread);
/* 988 */       _sb_.append(")");
/* 989 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossServerFriendsCircleTread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */