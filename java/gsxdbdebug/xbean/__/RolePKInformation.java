/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
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
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class RolePKInformation extends XBean implements xbean.RolePKInformation
/*      */ {
/*      */   private int update_time;
/*      */   private int pk_mode_expire_time;
/*      */   private int protection_expire_time;
/*      */   private int force_protection_expire_time;
/*      */   private int active_pk_times;
/*      */   private int pk_death_times;
/*      */   private int bought_moral_value;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.update_time = 0;
/*   31 */     this.pk_mode_expire_time = 0;
/*   32 */     this.protection_expire_time = 0;
/*   33 */     this.force_protection_expire_time = 0;
/*   34 */     this.active_pk_times = 0;
/*   35 */     this.pk_death_times = 0;
/*   36 */     this.bought_moral_value = 0;
/*      */   }
/*      */   
/*      */   RolePKInformation(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public RolePKInformation()
/*      */   {
/*   46 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RolePKInformation(RolePKInformation _o_)
/*      */   {
/*   51 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RolePKInformation(xbean.RolePKInformation _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     if ((_o1_ instanceof RolePKInformation)) { assign((RolePKInformation)_o1_);
/*   58 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   59 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   60 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RolePKInformation _o_) {
/*   65 */     _o_._xdb_verify_unsafe_();
/*   66 */     this.update_time = _o_.update_time;
/*   67 */     this.pk_mode_expire_time = _o_.pk_mode_expire_time;
/*   68 */     this.protection_expire_time = _o_.protection_expire_time;
/*   69 */     this.force_protection_expire_time = _o_.force_protection_expire_time;
/*   70 */     this.active_pk_times = _o_.active_pk_times;
/*   71 */     this.pk_death_times = _o_.pk_death_times;
/*   72 */     this.bought_moral_value = _o_.bought_moral_value;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   77 */     this.update_time = _o_.update_time;
/*   78 */     this.pk_mode_expire_time = _o_.pk_mode_expire_time;
/*   79 */     this.protection_expire_time = _o_.protection_expire_time;
/*   80 */     this.force_protection_expire_time = _o_.force_protection_expire_time;
/*   81 */     this.active_pk_times = _o_.active_pk_times;
/*   82 */     this.pk_death_times = _o_.pk_death_times;
/*   83 */     this.bought_moral_value = _o_.bought_moral_value;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   89 */     _xdb_verify_unsafe_();
/*   90 */     _os_.marshal(this.update_time);
/*   91 */     _os_.marshal(this.pk_mode_expire_time);
/*   92 */     _os_.marshal(this.protection_expire_time);
/*   93 */     _os_.marshal(this.force_protection_expire_time);
/*   94 */     _os_.marshal(this.active_pk_times);
/*   95 */     _os_.marshal(this.pk_death_times);
/*   96 */     _os_.marshal(this.bought_moral_value);
/*   97 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     this.update_time = _os_.unmarshal_int();
/*  105 */     this.pk_mode_expire_time = _os_.unmarshal_int();
/*  106 */     this.protection_expire_time = _os_.unmarshal_int();
/*  107 */     this.force_protection_expire_time = _os_.unmarshal_int();
/*  108 */     this.active_pk_times = _os_.unmarshal_int();
/*  109 */     this.pk_death_times = _os_.unmarshal_int();
/*  110 */     this.bought_moral_value = _os_.unmarshal_int();
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     int _size_ = 0;
/*  119 */     _size_ += CodedOutputStream.computeInt32Size(1, this.update_time);
/*  120 */     _size_ += CodedOutputStream.computeInt32Size(2, this.pk_mode_expire_time);
/*  121 */     _size_ += CodedOutputStream.computeInt32Size(3, this.protection_expire_time);
/*  122 */     _size_ += CodedOutputStream.computeInt32Size(4, this.force_protection_expire_time);
/*  123 */     _size_ += CodedOutputStream.computeInt32Size(5, this.active_pk_times);
/*  124 */     _size_ += CodedOutputStream.computeInt32Size(6, this.pk_death_times);
/*  125 */     _size_ += CodedOutputStream.computeInt32Size(7, this.bought_moral_value);
/*  126 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  135 */       _output_.writeInt32(1, this.update_time);
/*  136 */       _output_.writeInt32(2, this.pk_mode_expire_time);
/*  137 */       _output_.writeInt32(3, this.protection_expire_time);
/*  138 */       _output_.writeInt32(4, this.force_protection_expire_time);
/*  139 */       _output_.writeInt32(5, this.active_pk_times);
/*  140 */       _output_.writeInt32(6, this.pk_death_times);
/*  141 */       _output_.writeInt32(7, this.bought_moral_value);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  145 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  147 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  153 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  156 */       boolean done = false;
/*  157 */       while (!done)
/*      */       {
/*  159 */         int tag = _input_.readTag();
/*  160 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  164 */           done = true;
/*  165 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  169 */           this.update_time = _input_.readInt32();
/*  170 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  174 */           this.pk_mode_expire_time = _input_.readInt32();
/*  175 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  179 */           this.protection_expire_time = _input_.readInt32();
/*  180 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  184 */           this.force_protection_expire_time = _input_.readInt32();
/*  185 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  189 */           this.active_pk_times = _input_.readInt32();
/*  190 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  194 */           this.pk_death_times = _input_.readInt32();
/*  195 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  199 */           this.bought_moral_value = _input_.readInt32();
/*  200 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  204 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  206 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  215 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  219 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  221 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RolePKInformation copy()
/*      */   {
/*  227 */     _xdb_verify_unsafe_();
/*  228 */     return new RolePKInformation(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RolePKInformation toData()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RolePKInformation toBean()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return new RolePKInformation(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RolePKInformation toDataIf()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RolePKInformation toBeanIf()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getUpdate_time()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return this.update_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPk_mode_expire_time()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return this.pk_mode_expire_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getProtection_expire_time()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return this.protection_expire_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getForce_protection_expire_time()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this.force_protection_expire_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActive_pk_times()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.active_pk_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPk_death_times()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this.pk_death_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBought_moral_value()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return this.bought_moral_value;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUpdate_time(int _v_)
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     Logs.logIf(new LogKey(this, "update_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  329 */         new LogInt(this, RolePKInformation.this.update_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  333 */             RolePKInformation.this.update_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  337 */     });
/*  338 */     this.update_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPk_mode_expire_time(int _v_)
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     Logs.logIf(new LogKey(this, "pk_mode_expire_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  350 */         new LogInt(this, RolePKInformation.this.pk_mode_expire_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  354 */             RolePKInformation.this.pk_mode_expire_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  358 */     });
/*  359 */     this.pk_mode_expire_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setProtection_expire_time(int _v_)
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     Logs.logIf(new LogKey(this, "protection_expire_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  371 */         new LogInt(this, RolePKInformation.this.protection_expire_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  375 */             RolePKInformation.this.protection_expire_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  379 */     });
/*  380 */     this.protection_expire_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setForce_protection_expire_time(int _v_)
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     Logs.logIf(new LogKey(this, "force_protection_expire_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  392 */         new LogInt(this, RolePKInformation.this.force_protection_expire_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  396 */             RolePKInformation.this.force_protection_expire_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  400 */     });
/*  401 */     this.force_protection_expire_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActive_pk_times(int _v_)
/*      */   {
/*  408 */     _xdb_verify_unsafe_();
/*  409 */     Logs.logIf(new LogKey(this, "active_pk_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  413 */         new LogInt(this, RolePKInformation.this.active_pk_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  417 */             RolePKInformation.this.active_pk_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  421 */     });
/*  422 */     this.active_pk_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPk_death_times(int _v_)
/*      */   {
/*  429 */     _xdb_verify_unsafe_();
/*  430 */     Logs.logIf(new LogKey(this, "pk_death_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  434 */         new LogInt(this, RolePKInformation.this.pk_death_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  438 */             RolePKInformation.this.pk_death_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  442 */     });
/*  443 */     this.pk_death_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBought_moral_value(int _v_)
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     Logs.logIf(new LogKey(this, "bought_moral_value")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  455 */         new LogInt(this, RolePKInformation.this.bought_moral_value)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  459 */             RolePKInformation.this.bought_moral_value = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  463 */     });
/*  464 */     this.bought_moral_value = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  470 */     _xdb_verify_unsafe_();
/*  471 */     RolePKInformation _o_ = null;
/*  472 */     if ((_o1_ instanceof RolePKInformation)) { _o_ = (RolePKInformation)_o1_;
/*  473 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  474 */       return false;
/*  475 */     if (this.update_time != _o_.update_time) return false;
/*  476 */     if (this.pk_mode_expire_time != _o_.pk_mode_expire_time) return false;
/*  477 */     if (this.protection_expire_time != _o_.protection_expire_time) return false;
/*  478 */     if (this.force_protection_expire_time != _o_.force_protection_expire_time) return false;
/*  479 */     if (this.active_pk_times != _o_.active_pk_times) return false;
/*  480 */     if (this.pk_death_times != _o_.pk_death_times) return false;
/*  481 */     if (this.bought_moral_value != _o_.bought_moral_value) return false;
/*  482 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  488 */     _xdb_verify_unsafe_();
/*  489 */     int _h_ = 0;
/*  490 */     _h_ += this.update_time;
/*  491 */     _h_ += this.pk_mode_expire_time;
/*  492 */     _h_ += this.protection_expire_time;
/*  493 */     _h_ += this.force_protection_expire_time;
/*  494 */     _h_ += this.active_pk_times;
/*  495 */     _h_ += this.pk_death_times;
/*  496 */     _h_ += this.bought_moral_value;
/*  497 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     StringBuilder _sb_ = new StringBuilder();
/*  505 */     _sb_.append("(");
/*  506 */     _sb_.append(this.update_time);
/*  507 */     _sb_.append(",");
/*  508 */     _sb_.append(this.pk_mode_expire_time);
/*  509 */     _sb_.append(",");
/*  510 */     _sb_.append(this.protection_expire_time);
/*  511 */     _sb_.append(",");
/*  512 */     _sb_.append(this.force_protection_expire_time);
/*  513 */     _sb_.append(",");
/*  514 */     _sb_.append(this.active_pk_times);
/*  515 */     _sb_.append(",");
/*  516 */     _sb_.append(this.pk_death_times);
/*  517 */     _sb_.append(",");
/*  518 */     _sb_.append(this.bought_moral_value);
/*  519 */     _sb_.append(")");
/*  520 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  526 */     ListenableBean lb = new ListenableBean();
/*  527 */     lb.add(new ListenableChanged().setVarName("update_time"));
/*  528 */     lb.add(new ListenableChanged().setVarName("pk_mode_expire_time"));
/*  529 */     lb.add(new ListenableChanged().setVarName("protection_expire_time"));
/*  530 */     lb.add(new ListenableChanged().setVarName("force_protection_expire_time"));
/*  531 */     lb.add(new ListenableChanged().setVarName("active_pk_times"));
/*  532 */     lb.add(new ListenableChanged().setVarName("pk_death_times"));
/*  533 */     lb.add(new ListenableChanged().setVarName("bought_moral_value"));
/*  534 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RolePKInformation {
/*      */     private Const() {}
/*      */     
/*      */     RolePKInformation nThis() {
/*  541 */       return RolePKInformation.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  547 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RolePKInformation copy()
/*      */     {
/*  553 */       return RolePKInformation.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RolePKInformation toData()
/*      */     {
/*  559 */       return RolePKInformation.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RolePKInformation toBean()
/*      */     {
/*  564 */       return RolePKInformation.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RolePKInformation toDataIf()
/*      */     {
/*  570 */       return RolePKInformation.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RolePKInformation toBeanIf()
/*      */     {
/*  575 */       return RolePKInformation.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUpdate_time()
/*      */     {
/*  582 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  583 */       return RolePKInformation.this.update_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPk_mode_expire_time()
/*      */     {
/*  590 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  591 */       return RolePKInformation.this.pk_mode_expire_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getProtection_expire_time()
/*      */     {
/*  598 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  599 */       return RolePKInformation.this.protection_expire_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getForce_protection_expire_time()
/*      */     {
/*  606 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  607 */       return RolePKInformation.this.force_protection_expire_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActive_pk_times()
/*      */     {
/*  614 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  615 */       return RolePKInformation.this.active_pk_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPk_death_times()
/*      */     {
/*  622 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  623 */       return RolePKInformation.this.pk_death_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBought_moral_value()
/*      */     {
/*  630 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  631 */       return RolePKInformation.this.bought_moral_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdate_time(int _v_)
/*      */     {
/*  638 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  639 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPk_mode_expire_time(int _v_)
/*      */     {
/*  646 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  647 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setProtection_expire_time(int _v_)
/*      */     {
/*  654 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  655 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setForce_protection_expire_time(int _v_)
/*      */     {
/*  662 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  663 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_pk_times(int _v_)
/*      */     {
/*  670 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  671 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPk_death_times(int _v_)
/*      */     {
/*  678 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  679 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBought_moral_value(int _v_)
/*      */     {
/*  686 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  687 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  693 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  694 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  700 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  701 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  707 */       return RolePKInformation.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  713 */       return RolePKInformation.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  719 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  720 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  726 */       return RolePKInformation.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  732 */       return RolePKInformation.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  738 */       RolePKInformation.this._xdb_verify_unsafe_();
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  745 */       return RolePKInformation.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  751 */       return RolePKInformation.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  757 */       return RolePKInformation.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  763 */       return RolePKInformation.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  769 */       return RolePKInformation.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  775 */       return RolePKInformation.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  781 */       return RolePKInformation.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RolePKInformation
/*      */   {
/*      */     private int update_time;
/*      */     
/*      */     private int pk_mode_expire_time;
/*      */     
/*      */     private int protection_expire_time;
/*      */     
/*      */     private int force_protection_expire_time;
/*      */     
/*      */     private int active_pk_times;
/*      */     
/*      */     private int pk_death_times;
/*      */     
/*      */     private int bought_moral_value;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  805 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.RolePKInformation _o1_)
/*      */     {
/*  814 */       if ((_o1_ instanceof RolePKInformation)) { assign((RolePKInformation)_o1_);
/*  815 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  816 */       } else if ((_o1_ instanceof RolePKInformation.Const)) assign(((RolePKInformation.Const)_o1_).nThis()); else {
/*  817 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RolePKInformation _o_) {
/*  822 */       this.update_time = _o_.update_time;
/*  823 */       this.pk_mode_expire_time = _o_.pk_mode_expire_time;
/*  824 */       this.protection_expire_time = _o_.protection_expire_time;
/*  825 */       this.force_protection_expire_time = _o_.force_protection_expire_time;
/*  826 */       this.active_pk_times = _o_.active_pk_times;
/*  827 */       this.pk_death_times = _o_.pk_death_times;
/*  828 */       this.bought_moral_value = _o_.bought_moral_value;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  833 */       this.update_time = _o_.update_time;
/*  834 */       this.pk_mode_expire_time = _o_.pk_mode_expire_time;
/*  835 */       this.protection_expire_time = _o_.protection_expire_time;
/*  836 */       this.force_protection_expire_time = _o_.force_protection_expire_time;
/*  837 */       this.active_pk_times = _o_.active_pk_times;
/*  838 */       this.pk_death_times = _o_.pk_death_times;
/*  839 */       this.bought_moral_value = _o_.bought_moral_value;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  845 */       _os_.marshal(this.update_time);
/*  846 */       _os_.marshal(this.pk_mode_expire_time);
/*  847 */       _os_.marshal(this.protection_expire_time);
/*  848 */       _os_.marshal(this.force_protection_expire_time);
/*  849 */       _os_.marshal(this.active_pk_times);
/*  850 */       _os_.marshal(this.pk_death_times);
/*  851 */       _os_.marshal(this.bought_moral_value);
/*  852 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  858 */       this.update_time = _os_.unmarshal_int();
/*  859 */       this.pk_mode_expire_time = _os_.unmarshal_int();
/*  860 */       this.protection_expire_time = _os_.unmarshal_int();
/*  861 */       this.force_protection_expire_time = _os_.unmarshal_int();
/*  862 */       this.active_pk_times = _os_.unmarshal_int();
/*  863 */       this.pk_death_times = _os_.unmarshal_int();
/*  864 */       this.bought_moral_value = _os_.unmarshal_int();
/*  865 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  871 */       int _size_ = 0;
/*  872 */       _size_ += CodedOutputStream.computeInt32Size(1, this.update_time);
/*  873 */       _size_ += CodedOutputStream.computeInt32Size(2, this.pk_mode_expire_time);
/*  874 */       _size_ += CodedOutputStream.computeInt32Size(3, this.protection_expire_time);
/*  875 */       _size_ += CodedOutputStream.computeInt32Size(4, this.force_protection_expire_time);
/*  876 */       _size_ += CodedOutputStream.computeInt32Size(5, this.active_pk_times);
/*  877 */       _size_ += CodedOutputStream.computeInt32Size(6, this.pk_death_times);
/*  878 */       _size_ += CodedOutputStream.computeInt32Size(7, this.bought_moral_value);
/*  879 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  887 */         _output_.writeInt32(1, this.update_time);
/*  888 */         _output_.writeInt32(2, this.pk_mode_expire_time);
/*  889 */         _output_.writeInt32(3, this.protection_expire_time);
/*  890 */         _output_.writeInt32(4, this.force_protection_expire_time);
/*  891 */         _output_.writeInt32(5, this.active_pk_times);
/*  892 */         _output_.writeInt32(6, this.pk_death_times);
/*  893 */         _output_.writeInt32(7, this.bought_moral_value);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  897 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  899 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  907 */         boolean done = false;
/*  908 */         while (!done)
/*      */         {
/*  910 */           int tag = _input_.readTag();
/*  911 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  915 */             done = true;
/*  916 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  920 */             this.update_time = _input_.readInt32();
/*  921 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  925 */             this.pk_mode_expire_time = _input_.readInt32();
/*  926 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  930 */             this.protection_expire_time = _input_.readInt32();
/*  931 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  935 */             this.force_protection_expire_time = _input_.readInt32();
/*  936 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  940 */             this.active_pk_times = _input_.readInt32();
/*  941 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  945 */             this.pk_death_times = _input_.readInt32();
/*  946 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  950 */             this.bought_moral_value = _input_.readInt32();
/*  951 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  955 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  957 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  966 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  970 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  972 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RolePKInformation copy()
/*      */     {
/*  978 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RolePKInformation toData()
/*      */     {
/*  984 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RolePKInformation toBean()
/*      */     {
/*  989 */       return new RolePKInformation(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RolePKInformation toDataIf()
/*      */     {
/*  995 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RolePKInformation toBeanIf()
/*      */     {
/* 1000 */       return new RolePKInformation(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1006 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1010 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1014 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1018 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1022 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1026 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1030 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUpdate_time()
/*      */     {
/* 1037 */       return this.update_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPk_mode_expire_time()
/*      */     {
/* 1044 */       return this.pk_mode_expire_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getProtection_expire_time()
/*      */     {
/* 1051 */       return this.protection_expire_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getForce_protection_expire_time()
/*      */     {
/* 1058 */       return this.force_protection_expire_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActive_pk_times()
/*      */     {
/* 1065 */       return this.active_pk_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPk_death_times()
/*      */     {
/* 1072 */       return this.pk_death_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBought_moral_value()
/*      */     {
/* 1079 */       return this.bought_moral_value;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdate_time(int _v_)
/*      */     {
/* 1086 */       this.update_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPk_mode_expire_time(int _v_)
/*      */     {
/* 1093 */       this.pk_mode_expire_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setProtection_expire_time(int _v_)
/*      */     {
/* 1100 */       this.protection_expire_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setForce_protection_expire_time(int _v_)
/*      */     {
/* 1107 */       this.force_protection_expire_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_pk_times(int _v_)
/*      */     {
/* 1114 */       this.active_pk_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPk_death_times(int _v_)
/*      */     {
/* 1121 */       this.pk_death_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBought_moral_value(int _v_)
/*      */     {
/* 1128 */       this.bought_moral_value = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1134 */       if (!(_o1_ instanceof Data)) return false;
/* 1135 */       Data _o_ = (Data)_o1_;
/* 1136 */       if (this.update_time != _o_.update_time) return false;
/* 1137 */       if (this.pk_mode_expire_time != _o_.pk_mode_expire_time) return false;
/* 1138 */       if (this.protection_expire_time != _o_.protection_expire_time) return false;
/* 1139 */       if (this.force_protection_expire_time != _o_.force_protection_expire_time) return false;
/* 1140 */       if (this.active_pk_times != _o_.active_pk_times) return false;
/* 1141 */       if (this.pk_death_times != _o_.pk_death_times) return false;
/* 1142 */       if (this.bought_moral_value != _o_.bought_moral_value) return false;
/* 1143 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1149 */       int _h_ = 0;
/* 1150 */       _h_ += this.update_time;
/* 1151 */       _h_ += this.pk_mode_expire_time;
/* 1152 */       _h_ += this.protection_expire_time;
/* 1153 */       _h_ += this.force_protection_expire_time;
/* 1154 */       _h_ += this.active_pk_times;
/* 1155 */       _h_ += this.pk_death_times;
/* 1156 */       _h_ += this.bought_moral_value;
/* 1157 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1163 */       StringBuilder _sb_ = new StringBuilder();
/* 1164 */       _sb_.append("(");
/* 1165 */       _sb_.append(this.update_time);
/* 1166 */       _sb_.append(",");
/* 1167 */       _sb_.append(this.pk_mode_expire_time);
/* 1168 */       _sb_.append(",");
/* 1169 */       _sb_.append(this.protection_expire_time);
/* 1170 */       _sb_.append(",");
/* 1171 */       _sb_.append(this.force_protection_expire_time);
/* 1172 */       _sb_.append(",");
/* 1173 */       _sb_.append(this.active_pk_times);
/* 1174 */       _sb_.append(",");
/* 1175 */       _sb_.append(this.pk_death_times);
/* 1176 */       _sb_.append(",");
/* 1177 */       _sb_.append(this.bought_moral_value);
/* 1178 */       _sb_.append(")");
/* 1179 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RolePKInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */