/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class FriendsCircleTreadResult extends XBean implements xbean.FriendsCircleTreadResult
/*      */ {
/*      */   private long tread_me_role_id;
/*      */   private int tread_me_zone_id;
/*      */   private boolean is_trigger_box;
/*      */   private boolean is_ssp_replied;
/*      */   private boolean is_cross_server;
/*      */   private int add_popularity_value;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.tread_me_role_id = 0L;
/*   29 */     this.tread_me_zone_id = 0;
/*   30 */     this.is_trigger_box = false;
/*   31 */     this.is_ssp_replied = false;
/*   32 */     this.is_cross_server = false;
/*   33 */     this.add_popularity_value = 0;
/*      */   }
/*      */   
/*      */   FriendsCircleTreadResult(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public FriendsCircleTreadResult()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FriendsCircleTreadResult(FriendsCircleTreadResult _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FriendsCircleTreadResult(xbean.FriendsCircleTreadResult _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof FriendsCircleTreadResult)) { assign((FriendsCircleTreadResult)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FriendsCircleTreadResult _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.tread_me_role_id = _o_.tread_me_role_id;
/*   64 */     this.tread_me_zone_id = _o_.tread_me_zone_id;
/*   65 */     this.is_trigger_box = _o_.is_trigger_box;
/*   66 */     this.is_ssp_replied = _o_.is_ssp_replied;
/*   67 */     this.is_cross_server = _o_.is_cross_server;
/*   68 */     this.add_popularity_value = _o_.add_popularity_value;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.tread_me_role_id = _o_.tread_me_role_id;
/*   74 */     this.tread_me_zone_id = _o_.tread_me_zone_id;
/*   75 */     this.is_trigger_box = _o_.is_trigger_box;
/*   76 */     this.is_ssp_replied = _o_.is_ssp_replied;
/*   77 */     this.is_cross_server = _o_.is_cross_server;
/*   78 */     this.add_popularity_value = _o_.add_popularity_value;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.tread_me_role_id);
/*   86 */     _os_.marshal(this.tread_me_zone_id);
/*   87 */     _os_.marshal(this.is_trigger_box);
/*   88 */     _os_.marshal(this.is_ssp_replied);
/*   89 */     _os_.marshal(this.is_cross_server);
/*   90 */     _os_.marshal(this.add_popularity_value);
/*   91 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   97 */     _xdb_verify_unsafe_();
/*   98 */     this.tread_me_role_id = _os_.unmarshal_long();
/*   99 */     this.tread_me_zone_id = _os_.unmarshal_int();
/*  100 */     this.is_trigger_box = _os_.unmarshal_boolean();
/*  101 */     this.is_ssp_replied = _os_.unmarshal_boolean();
/*  102 */     this.is_cross_server = _os_.unmarshal_boolean();
/*  103 */     this.add_popularity_value = _os_.unmarshal_int();
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     int _size_ = 0;
/*  112 */     _size_ += CodedOutputStream.computeInt64Size(1, this.tread_me_role_id);
/*  113 */     _size_ += CodedOutputStream.computeInt32Size(2, this.tread_me_zone_id);
/*  114 */     _size_ += CodedOutputStream.computeBoolSize(3, this.is_trigger_box);
/*  115 */     _size_ += CodedOutputStream.computeBoolSize(4, this.is_ssp_replied);
/*  116 */     _size_ += CodedOutputStream.computeBoolSize(5, this.is_cross_server);
/*  117 */     _size_ += CodedOutputStream.computeInt32Size(6, this.add_popularity_value);
/*  118 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  127 */       _output_.writeInt64(1, this.tread_me_role_id);
/*  128 */       _output_.writeInt32(2, this.tread_me_zone_id);
/*  129 */       _output_.writeBool(3, this.is_trigger_box);
/*  130 */       _output_.writeBool(4, this.is_ssp_replied);
/*  131 */       _output_.writeBool(5, this.is_cross_server);
/*  132 */       _output_.writeInt32(6, this.add_popularity_value);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  138 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       boolean done = false;
/*  148 */       while (!done)
/*      */       {
/*  150 */         int tag = _input_.readTag();
/*  151 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  155 */           done = true;
/*  156 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  160 */           this.tread_me_role_id = _input_.readInt64();
/*  161 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  165 */           this.tread_me_zone_id = _input_.readInt32();
/*  166 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  170 */           this.is_trigger_box = _input_.readBool();
/*  171 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  175 */           this.is_ssp_replied = _input_.readBool();
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  180 */           this.is_cross_server = _input_.readBool();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  185 */           this.add_popularity_value = _input_.readInt32();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  190 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  192 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  201 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  205 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  207 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FriendsCircleTreadResult copy()
/*      */   {
/*  213 */     _xdb_verify_unsafe_();
/*  214 */     return new FriendsCircleTreadResult(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FriendsCircleTreadResult toData()
/*      */   {
/*  220 */     _xdb_verify_unsafe_();
/*  221 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FriendsCircleTreadResult toBean()
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*  227 */     return new FriendsCircleTreadResult(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FriendsCircleTreadResult toDataIf()
/*      */   {
/*  233 */     _xdb_verify_unsafe_();
/*  234 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FriendsCircleTreadResult toBeanIf()
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*  240 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  246 */     _xdb_verify_unsafe_();
/*  247 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTread_me_role_id()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return this.tread_me_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTread_me_zone_id()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return this.tread_me_zone_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_trigger_box()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.is_trigger_box;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_ssp_replied()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return this.is_ssp_replied;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_cross_server()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.is_cross_server;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAdd_popularity_value()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.add_popularity_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTread_me_role_id(long _v_)
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     Logs.logIf(new LogKey(this, "tread_me_role_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  307 */         new xdb.logs.LogLong(this, FriendsCircleTreadResult.this.tread_me_role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  311 */             FriendsCircleTreadResult.this.tread_me_role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  315 */     });
/*  316 */     this.tread_me_role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTread_me_zone_id(int _v_)
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     Logs.logIf(new LogKey(this, "tread_me_zone_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  328 */         new xdb.logs.LogInt(this, FriendsCircleTreadResult.this.tread_me_zone_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  332 */             FriendsCircleTreadResult.this.tread_me_zone_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  336 */     });
/*  337 */     this.tread_me_zone_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_trigger_box(boolean _v_)
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     Logs.logIf(new LogKey(this, "is_trigger_box")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  349 */         new LogObject(this, Boolean.valueOf(FriendsCircleTreadResult.this.is_trigger_box))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  353 */             FriendsCircleTreadResult.this.is_trigger_box = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  357 */     });
/*  358 */     this.is_trigger_box = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_ssp_replied(boolean _v_)
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     Logs.logIf(new LogKey(this, "is_ssp_replied")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  370 */         new LogObject(this, Boolean.valueOf(FriendsCircleTreadResult.this.is_ssp_replied))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             FriendsCircleTreadResult.this.is_ssp_replied = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.is_ssp_replied = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_cross_server(boolean _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     Logs.logIf(new LogKey(this, "is_cross_server")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  391 */         new LogObject(this, Boolean.valueOf(FriendsCircleTreadResult.this.is_cross_server))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  395 */             FriendsCircleTreadResult.this.is_cross_server = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  399 */     });
/*  400 */     this.is_cross_server = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAdd_popularity_value(int _v_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     Logs.logIf(new LogKey(this, "add_popularity_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  412 */         new xdb.logs.LogInt(this, FriendsCircleTreadResult.this.add_popularity_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  416 */             FriendsCircleTreadResult.this.add_popularity_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  420 */     });
/*  421 */     this.add_popularity_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     FriendsCircleTreadResult _o_ = null;
/*  429 */     if ((_o1_ instanceof FriendsCircleTreadResult)) { _o_ = (FriendsCircleTreadResult)_o1_;
/*  430 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  431 */       return false;
/*  432 */     if (this.tread_me_role_id != _o_.tread_me_role_id) return false;
/*  433 */     if (this.tread_me_zone_id != _o_.tread_me_zone_id) return false;
/*  434 */     if (this.is_trigger_box != _o_.is_trigger_box) return false;
/*  435 */     if (this.is_ssp_replied != _o_.is_ssp_replied) return false;
/*  436 */     if (this.is_cross_server != _o_.is_cross_server) return false;
/*  437 */     if (this.add_popularity_value != _o_.add_popularity_value) return false;
/*  438 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     int _h_ = 0;
/*  446 */     _h_ = (int)(_h_ + this.tread_me_role_id);
/*  447 */     _h_ += this.tread_me_zone_id;
/*  448 */     _h_ += (this.is_trigger_box ? 1231 : 1237);
/*  449 */     _h_ += (this.is_ssp_replied ? 1231 : 1237);
/*  450 */     _h_ += (this.is_cross_server ? 1231 : 1237);
/*  451 */     _h_ += this.add_popularity_value;
/*  452 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*  459 */     StringBuilder _sb_ = new StringBuilder();
/*  460 */     _sb_.append("(");
/*  461 */     _sb_.append(this.tread_me_role_id);
/*  462 */     _sb_.append(",");
/*  463 */     _sb_.append(this.tread_me_zone_id);
/*  464 */     _sb_.append(",");
/*  465 */     _sb_.append(this.is_trigger_box);
/*  466 */     _sb_.append(",");
/*  467 */     _sb_.append(this.is_ssp_replied);
/*  468 */     _sb_.append(",");
/*  469 */     _sb_.append(this.is_cross_server);
/*  470 */     _sb_.append(",");
/*  471 */     _sb_.append(this.add_popularity_value);
/*  472 */     _sb_.append(")");
/*  473 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  479 */     ListenableBean lb = new ListenableBean();
/*  480 */     lb.add(new ListenableChanged().setVarName("tread_me_role_id"));
/*  481 */     lb.add(new ListenableChanged().setVarName("tread_me_zone_id"));
/*  482 */     lb.add(new ListenableChanged().setVarName("is_trigger_box"));
/*  483 */     lb.add(new ListenableChanged().setVarName("is_ssp_replied"));
/*  484 */     lb.add(new ListenableChanged().setVarName("is_cross_server"));
/*  485 */     lb.add(new ListenableChanged().setVarName("add_popularity_value"));
/*  486 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FriendsCircleTreadResult {
/*      */     private Const() {}
/*      */     
/*      */     FriendsCircleTreadResult nThis() {
/*  493 */       return FriendsCircleTreadResult.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  499 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleTreadResult copy()
/*      */     {
/*  505 */       return FriendsCircleTreadResult.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleTreadResult toData()
/*      */     {
/*  511 */       return FriendsCircleTreadResult.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FriendsCircleTreadResult toBean()
/*      */     {
/*  516 */       return FriendsCircleTreadResult.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleTreadResult toDataIf()
/*      */     {
/*  522 */       return FriendsCircleTreadResult.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FriendsCircleTreadResult toBeanIf()
/*      */     {
/*  527 */       return FriendsCircleTreadResult.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTread_me_role_id()
/*      */     {
/*  534 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  535 */       return FriendsCircleTreadResult.this.tread_me_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTread_me_zone_id()
/*      */     {
/*  542 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  543 */       return FriendsCircleTreadResult.this.tread_me_zone_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_trigger_box()
/*      */     {
/*  550 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  551 */       return FriendsCircleTreadResult.this.is_trigger_box;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_ssp_replied()
/*      */     {
/*  558 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  559 */       return FriendsCircleTreadResult.this.is_ssp_replied;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_cross_server()
/*      */     {
/*  566 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  567 */       return FriendsCircleTreadResult.this.is_cross_server;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAdd_popularity_value()
/*      */     {
/*  574 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  575 */       return FriendsCircleTreadResult.this.add_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTread_me_role_id(long _v_)
/*      */     {
/*  582 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  583 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTread_me_zone_id(int _v_)
/*      */     {
/*  590 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  591 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_trigger_box(boolean _v_)
/*      */     {
/*  598 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  599 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_ssp_replied(boolean _v_)
/*      */     {
/*  606 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  607 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_cross_server(boolean _v_)
/*      */     {
/*  614 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  615 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdd_popularity_value(int _v_)
/*      */     {
/*  622 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  629 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  630 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  636 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  637 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  643 */       return FriendsCircleTreadResult.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  649 */       return FriendsCircleTreadResult.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  655 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  656 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  662 */       return FriendsCircleTreadResult.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  668 */       return FriendsCircleTreadResult.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  674 */       FriendsCircleTreadResult.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  681 */       return FriendsCircleTreadResult.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  687 */       return FriendsCircleTreadResult.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  693 */       return FriendsCircleTreadResult.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  699 */       return FriendsCircleTreadResult.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  705 */       return FriendsCircleTreadResult.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  711 */       return FriendsCircleTreadResult.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  717 */       return FriendsCircleTreadResult.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FriendsCircleTreadResult
/*      */   {
/*      */     private long tread_me_role_id;
/*      */     
/*      */     private int tread_me_zone_id;
/*      */     
/*      */     private boolean is_trigger_box;
/*      */     
/*      */     private boolean is_ssp_replied;
/*      */     
/*      */     private boolean is_cross_server;
/*      */     
/*      */     private int add_popularity_value;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.FriendsCircleTreadResult _o1_)
/*      */     {
/*  748 */       if ((_o1_ instanceof FriendsCircleTreadResult)) { assign((FriendsCircleTreadResult)_o1_);
/*  749 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  750 */       } else if ((_o1_ instanceof FriendsCircleTreadResult.Const)) assign(((FriendsCircleTreadResult.Const)_o1_).nThis()); else {
/*  751 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FriendsCircleTreadResult _o_) {
/*  756 */       this.tread_me_role_id = _o_.tread_me_role_id;
/*  757 */       this.tread_me_zone_id = _o_.tread_me_zone_id;
/*  758 */       this.is_trigger_box = _o_.is_trigger_box;
/*  759 */       this.is_ssp_replied = _o_.is_ssp_replied;
/*  760 */       this.is_cross_server = _o_.is_cross_server;
/*  761 */       this.add_popularity_value = _o_.add_popularity_value;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  766 */       this.tread_me_role_id = _o_.tread_me_role_id;
/*  767 */       this.tread_me_zone_id = _o_.tread_me_zone_id;
/*  768 */       this.is_trigger_box = _o_.is_trigger_box;
/*  769 */       this.is_ssp_replied = _o_.is_ssp_replied;
/*  770 */       this.is_cross_server = _o_.is_cross_server;
/*  771 */       this.add_popularity_value = _o_.add_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  777 */       _os_.marshal(this.tread_me_role_id);
/*  778 */       _os_.marshal(this.tread_me_zone_id);
/*  779 */       _os_.marshal(this.is_trigger_box);
/*  780 */       _os_.marshal(this.is_ssp_replied);
/*  781 */       _os_.marshal(this.is_cross_server);
/*  782 */       _os_.marshal(this.add_popularity_value);
/*  783 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  789 */       this.tread_me_role_id = _os_.unmarshal_long();
/*  790 */       this.tread_me_zone_id = _os_.unmarshal_int();
/*  791 */       this.is_trigger_box = _os_.unmarshal_boolean();
/*  792 */       this.is_ssp_replied = _os_.unmarshal_boolean();
/*  793 */       this.is_cross_server = _os_.unmarshal_boolean();
/*  794 */       this.add_popularity_value = _os_.unmarshal_int();
/*  795 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  801 */       int _size_ = 0;
/*  802 */       _size_ += CodedOutputStream.computeInt64Size(1, this.tread_me_role_id);
/*  803 */       _size_ += CodedOutputStream.computeInt32Size(2, this.tread_me_zone_id);
/*  804 */       _size_ += CodedOutputStream.computeBoolSize(3, this.is_trigger_box);
/*  805 */       _size_ += CodedOutputStream.computeBoolSize(4, this.is_ssp_replied);
/*  806 */       _size_ += CodedOutputStream.computeBoolSize(5, this.is_cross_server);
/*  807 */       _size_ += CodedOutputStream.computeInt32Size(6, this.add_popularity_value);
/*  808 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  816 */         _output_.writeInt64(1, this.tread_me_role_id);
/*  817 */         _output_.writeInt32(2, this.tread_me_zone_id);
/*  818 */         _output_.writeBool(3, this.is_trigger_box);
/*  819 */         _output_.writeBool(4, this.is_ssp_replied);
/*  820 */         _output_.writeBool(5, this.is_cross_server);
/*  821 */         _output_.writeInt32(6, this.add_popularity_value);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  825 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  827 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  835 */         boolean done = false;
/*  836 */         while (!done)
/*      */         {
/*  838 */           int tag = _input_.readTag();
/*  839 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  843 */             done = true;
/*  844 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  848 */             this.tread_me_role_id = _input_.readInt64();
/*  849 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  853 */             this.tread_me_zone_id = _input_.readInt32();
/*  854 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  858 */             this.is_trigger_box = _input_.readBool();
/*  859 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  863 */             this.is_ssp_replied = _input_.readBool();
/*  864 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  868 */             this.is_cross_server = _input_.readBool();
/*  869 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  873 */             this.add_popularity_value = _input_.readInt32();
/*  874 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  878 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  880 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  889 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  893 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  895 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleTreadResult copy()
/*      */     {
/*  901 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleTreadResult toData()
/*      */     {
/*  907 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FriendsCircleTreadResult toBean()
/*      */     {
/*  912 */       return new FriendsCircleTreadResult(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendsCircleTreadResult toDataIf()
/*      */     {
/*  918 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FriendsCircleTreadResult toBeanIf()
/*      */     {
/*  923 */       return new FriendsCircleTreadResult(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  929 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  949 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  953 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTread_me_role_id()
/*      */     {
/*  960 */       return this.tread_me_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTread_me_zone_id()
/*      */     {
/*  967 */       return this.tread_me_zone_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_trigger_box()
/*      */     {
/*  974 */       return this.is_trigger_box;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_ssp_replied()
/*      */     {
/*  981 */       return this.is_ssp_replied;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_cross_server()
/*      */     {
/*  988 */       return this.is_cross_server;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAdd_popularity_value()
/*      */     {
/*  995 */       return this.add_popularity_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTread_me_role_id(long _v_)
/*      */     {
/* 1002 */       this.tread_me_role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTread_me_zone_id(int _v_)
/*      */     {
/* 1009 */       this.tread_me_zone_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_trigger_box(boolean _v_)
/*      */     {
/* 1016 */       this.is_trigger_box = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_ssp_replied(boolean _v_)
/*      */     {
/* 1023 */       this.is_ssp_replied = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_cross_server(boolean _v_)
/*      */     {
/* 1030 */       this.is_cross_server = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdd_popularity_value(int _v_)
/*      */     {
/* 1037 */       this.add_popularity_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1043 */       if (!(_o1_ instanceof Data)) return false;
/* 1044 */       Data _o_ = (Data)_o1_;
/* 1045 */       if (this.tread_me_role_id != _o_.tread_me_role_id) return false;
/* 1046 */       if (this.tread_me_zone_id != _o_.tread_me_zone_id) return false;
/* 1047 */       if (this.is_trigger_box != _o_.is_trigger_box) return false;
/* 1048 */       if (this.is_ssp_replied != _o_.is_ssp_replied) return false;
/* 1049 */       if (this.is_cross_server != _o_.is_cross_server) return false;
/* 1050 */       if (this.add_popularity_value != _o_.add_popularity_value) return false;
/* 1051 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1057 */       int _h_ = 0;
/* 1058 */       _h_ = (int)(_h_ + this.tread_me_role_id);
/* 1059 */       _h_ += this.tread_me_zone_id;
/* 1060 */       _h_ += (this.is_trigger_box ? 1231 : 1237);
/* 1061 */       _h_ += (this.is_ssp_replied ? 1231 : 1237);
/* 1062 */       _h_ += (this.is_cross_server ? 1231 : 1237);
/* 1063 */       _h_ += this.add_popularity_value;
/* 1064 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1070 */       StringBuilder _sb_ = new StringBuilder();
/* 1071 */       _sb_.append("(");
/* 1072 */       _sb_.append(this.tread_me_role_id);
/* 1073 */       _sb_.append(",");
/* 1074 */       _sb_.append(this.tread_me_zone_id);
/* 1075 */       _sb_.append(",");
/* 1076 */       _sb_.append(this.is_trigger_box);
/* 1077 */       _sb_.append(",");
/* 1078 */       _sb_.append(this.is_ssp_replied);
/* 1079 */       _sb_.append(",");
/* 1080 */       _sb_.append(this.is_cross_server);
/* 1081 */       _sb_.append(",");
/* 1082 */       _sb_.append(this.add_popularity_value);
/* 1083 */       _sb_.append(")");
/* 1084 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FriendsCircleTreadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */