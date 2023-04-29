/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class AllLottoAwardRoleInfo extends XBean implements xbean.AllLottoAwardRoleInfo
/*      */ {
/*      */   private long roleid;
/*      */   private String role_name;
/*      */   private int occupation;
/*      */   private int gender;
/*      */   private int level;
/*      */   private int avatarid;
/*      */   private int avatar_frameid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.roleid = 0L;
/*   31 */     this.role_name = "";
/*   32 */     this.occupation = 0;
/*   33 */     this.gender = 0;
/*   34 */     this.level = 0;
/*   35 */     this.avatarid = 0;
/*   36 */     this.avatar_frameid = 0;
/*      */   }
/*      */   
/*      */   AllLottoAwardRoleInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.roleid = 0L;
/*   43 */     this.role_name = "";
/*      */   }
/*      */   
/*      */   public AllLottoAwardRoleInfo()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AllLottoAwardRoleInfo(AllLottoAwardRoleInfo _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AllLottoAwardRoleInfo(xbean.AllLottoAwardRoleInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof AllLottoAwardRoleInfo)) { assign((AllLottoAwardRoleInfo)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AllLottoAwardRoleInfo _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.roleid = _o_.roleid;
/*   69 */     this.role_name = _o_.role_name;
/*   70 */     this.occupation = _o_.occupation;
/*   71 */     this.gender = _o_.gender;
/*   72 */     this.level = _o_.level;
/*   73 */     this.avatarid = _o_.avatarid;
/*   74 */     this.avatar_frameid = _o_.avatar_frameid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.roleid = _o_.roleid;
/*   80 */     this.role_name = _o_.role_name;
/*   81 */     this.occupation = _o_.occupation;
/*   82 */     this.gender = _o_.gender;
/*   83 */     this.level = _o_.level;
/*   84 */     this.avatarid = _o_.avatarid;
/*   85 */     this.avatar_frameid = _o_.avatar_frameid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   91 */     _xdb_verify_unsafe_();
/*   92 */     _os_.marshal(this.roleid);
/*   93 */     _os_.marshal(this.role_name, "UTF-16LE");
/*   94 */     _os_.marshal(this.occupation);
/*   95 */     _os_.marshal(this.gender);
/*   96 */     _os_.marshal(this.level);
/*   97 */     _os_.marshal(this.avatarid);
/*   98 */     _os_.marshal(this.avatar_frameid);
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.roleid = _os_.unmarshal_long();
/*  107 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/*  108 */     this.occupation = _os_.unmarshal_int();
/*  109 */     this.gender = _os_.unmarshal_int();
/*  110 */     this.level = _os_.unmarshal_int();
/*  111 */     this.avatarid = _os_.unmarshal_int();
/*  112 */     this.avatar_frameid = _os_.unmarshal_int();
/*  113 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  119 */     _xdb_verify_unsafe_();
/*  120 */     int _size_ = 0;
/*  121 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*      */     try
/*      */     {
/*  124 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  128 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  130 */     _size_ += CodedOutputStream.computeInt32Size(3, this.occupation);
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(4, this.gender);
/*  132 */     _size_ += CodedOutputStream.computeInt32Size(5, this.level);
/*  133 */     _size_ += CodedOutputStream.computeInt32Size(6, this.avatarid);
/*  134 */     _size_ += CodedOutputStream.computeInt32Size(7, this.avatar_frameid);
/*  135 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  141 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  144 */       _output_.writeInt64(1, this.roleid);
/*  145 */       _output_.writeBytes(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*  146 */       _output_.writeInt32(3, this.occupation);
/*  147 */       _output_.writeInt32(4, this.gender);
/*  148 */       _output_.writeInt32(5, this.level);
/*  149 */       _output_.writeInt32(6, this.avatarid);
/*  150 */       _output_.writeInt32(7, this.avatar_frameid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  154 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  156 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       boolean done = false;
/*  166 */       while (!done)
/*      */       {
/*  168 */         int tag = _input_.readTag();
/*  169 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  173 */           done = true;
/*  174 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  178 */           this.roleid = _input_.readInt64();
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  183 */           this.role_name = _input_.readBytes().toString("UTF-16LE");
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  188 */           this.occupation = _input_.readInt32();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  193 */           this.gender = _input_.readInt32();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  198 */           this.level = _input_.readInt32();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  203 */           this.avatarid = _input_.readInt32();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  208 */           this.avatar_frameid = _input_.readInt32();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  213 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  215 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  224 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  228 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  230 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AllLottoAwardRoleInfo copy()
/*      */   {
/*  236 */     _xdb_verify_unsafe_();
/*  237 */     return new AllLottoAwardRoleInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AllLottoAwardRoleInfo toData()
/*      */   {
/*  243 */     _xdb_verify_unsafe_();
/*  244 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AllLottoAwardRoleInfo toBean()
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*  250 */     return new AllLottoAwardRoleInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AllLottoAwardRoleInfo toDataIf()
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*  257 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AllLottoAwardRoleInfo toBeanIf()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getRole_name()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return this.role_name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getRole_nameOctets()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return Octets.wrap(getRole_name(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOccupation()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return this.occupation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGender()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return this.gender;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*  318 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAvatarid()
/*      */   {
/*  325 */     _xdb_verify_unsafe_();
/*  326 */     return this.avatarid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAvatar_frameid()
/*      */   {
/*  333 */     _xdb_verify_unsafe_();
/*  334 */     return this.avatar_frameid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  341 */     _xdb_verify_unsafe_();
/*  342 */     Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  346 */         new xdb.logs.LogLong(this, AllLottoAwardRoleInfo.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  350 */             AllLottoAwardRoleInfo.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  354 */     });
/*  355 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRole_name(String _v_)
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     if (null == _v_)
/*  364 */       throw new NullPointerException();
/*  365 */     Logs.logIf(new LogKey(this, "role_name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  369 */         new xdb.logs.LogString(this, AllLottoAwardRoleInfo.this.role_name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  373 */             AllLottoAwardRoleInfo.this.role_name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  377 */     });
/*  378 */     this.role_name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRole_nameOctets(Octets _v_)
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     setRole_name(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOccupation(int _v_)
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     Logs.logIf(new LogKey(this, "occupation")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  398 */         new LogInt(this, AllLottoAwardRoleInfo.this.occupation)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  402 */             AllLottoAwardRoleInfo.this.occupation = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  406 */     });
/*  407 */     this.occupation = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGender(int _v_)
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     Logs.logIf(new LogKey(this, "gender")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  419 */         new LogInt(this, AllLottoAwardRoleInfo.this.gender)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  423 */             AllLottoAwardRoleInfo.this.gender = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  427 */     });
/*  428 */     this.gender = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  440 */         new LogInt(this, AllLottoAwardRoleInfo.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  444 */             AllLottoAwardRoleInfo.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  448 */     });
/*  449 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAvatarid(int _v_)
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     Logs.logIf(new LogKey(this, "avatarid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  461 */         new LogInt(this, AllLottoAwardRoleInfo.this.avatarid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  465 */             AllLottoAwardRoleInfo.this.avatarid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  469 */     });
/*  470 */     this.avatarid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAvatar_frameid(int _v_)
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     Logs.logIf(new LogKey(this, "avatar_frameid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  482 */         new LogInt(this, AllLottoAwardRoleInfo.this.avatar_frameid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  486 */             AllLottoAwardRoleInfo.this.avatar_frameid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  490 */     });
/*  491 */     this.avatar_frameid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     AllLottoAwardRoleInfo _o_ = null;
/*  499 */     if ((_o1_ instanceof AllLottoAwardRoleInfo)) { _o_ = (AllLottoAwardRoleInfo)_o1_;
/*  500 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  501 */       return false;
/*  502 */     if (this.roleid != _o_.roleid) return false;
/*  503 */     if (!this.role_name.equals(_o_.role_name)) return false;
/*  504 */     if (this.occupation != _o_.occupation) return false;
/*  505 */     if (this.gender != _o_.gender) return false;
/*  506 */     if (this.level != _o_.level) return false;
/*  507 */     if (this.avatarid != _o_.avatarid) return false;
/*  508 */     if (this.avatar_frameid != _o_.avatar_frameid) return false;
/*  509 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  515 */     _xdb_verify_unsafe_();
/*  516 */     int _h_ = 0;
/*  517 */     _h_ = (int)(_h_ + this.roleid);
/*  518 */     _h_ += this.role_name.hashCode();
/*  519 */     _h_ += this.occupation;
/*  520 */     _h_ += this.gender;
/*  521 */     _h_ += this.level;
/*  522 */     _h_ += this.avatarid;
/*  523 */     _h_ += this.avatar_frameid;
/*  524 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  530 */     _xdb_verify_unsafe_();
/*  531 */     StringBuilder _sb_ = new StringBuilder();
/*  532 */     _sb_.append("(");
/*  533 */     _sb_.append(this.roleid);
/*  534 */     _sb_.append(",");
/*  535 */     _sb_.append("'").append(this.role_name).append("'");
/*  536 */     _sb_.append(",");
/*  537 */     _sb_.append(this.occupation);
/*  538 */     _sb_.append(",");
/*  539 */     _sb_.append(this.gender);
/*  540 */     _sb_.append(",");
/*  541 */     _sb_.append(this.level);
/*  542 */     _sb_.append(",");
/*  543 */     _sb_.append(this.avatarid);
/*  544 */     _sb_.append(",");
/*  545 */     _sb_.append(this.avatar_frameid);
/*  546 */     _sb_.append(")");
/*  547 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  553 */     ListenableBean lb = new ListenableBean();
/*  554 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  555 */     lb.add(new ListenableChanged().setVarName("role_name"));
/*  556 */     lb.add(new ListenableChanged().setVarName("occupation"));
/*  557 */     lb.add(new ListenableChanged().setVarName("gender"));
/*  558 */     lb.add(new ListenableChanged().setVarName("level"));
/*  559 */     lb.add(new ListenableChanged().setVarName("avatarid"));
/*  560 */     lb.add(new ListenableChanged().setVarName("avatar_frameid"));
/*  561 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AllLottoAwardRoleInfo {
/*      */     private Const() {}
/*      */     
/*      */     AllLottoAwardRoleInfo nThis() {
/*  568 */       return AllLottoAwardRoleInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  574 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllLottoAwardRoleInfo copy()
/*      */     {
/*  580 */       return AllLottoAwardRoleInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllLottoAwardRoleInfo toData()
/*      */     {
/*  586 */       return AllLottoAwardRoleInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AllLottoAwardRoleInfo toBean()
/*      */     {
/*  591 */       return AllLottoAwardRoleInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllLottoAwardRoleInfo toDataIf()
/*      */     {
/*  597 */       return AllLottoAwardRoleInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AllLottoAwardRoleInfo toBeanIf()
/*      */     {
/*  602 */       return AllLottoAwardRoleInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  609 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  610 */       return AllLottoAwardRoleInfo.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRole_name()
/*      */     {
/*  617 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  618 */       return AllLottoAwardRoleInfo.this.role_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRole_nameOctets()
/*      */     {
/*  625 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  626 */       return AllLottoAwardRoleInfo.this.getRole_nameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupation()
/*      */     {
/*  633 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  634 */       return AllLottoAwardRoleInfo.this.occupation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGender()
/*      */     {
/*  641 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  642 */       return AllLottoAwardRoleInfo.this.gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/*  649 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  650 */       return AllLottoAwardRoleInfo.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvatarid()
/*      */     {
/*  657 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  658 */       return AllLottoAwardRoleInfo.this.avatarid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvatar_frameid()
/*      */     {
/*  665 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  666 */       return AllLottoAwardRoleInfo.this.avatar_frameid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  673 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  674 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_name(String _v_)
/*      */     {
/*  681 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  682 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_nameOctets(Octets _v_)
/*      */     {
/*  689 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  690 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupation(int _v_)
/*      */     {
/*  697 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  698 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGender(int _v_)
/*      */     {
/*  705 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  706 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/*  713 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  714 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvatarid(int _v_)
/*      */     {
/*  721 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  722 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvatar_frameid(int _v_)
/*      */     {
/*  729 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  730 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  736 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  737 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  743 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  744 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  750 */       return AllLottoAwardRoleInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  756 */       return AllLottoAwardRoleInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  762 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  763 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  769 */       return AllLottoAwardRoleInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  775 */       return AllLottoAwardRoleInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  781 */       AllLottoAwardRoleInfo.this._xdb_verify_unsafe_();
/*  782 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  788 */       return AllLottoAwardRoleInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  794 */       return AllLottoAwardRoleInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  800 */       return AllLottoAwardRoleInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  806 */       return AllLottoAwardRoleInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  812 */       return AllLottoAwardRoleInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  818 */       return AllLottoAwardRoleInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  824 */       return AllLottoAwardRoleInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AllLottoAwardRoleInfo
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private String role_name;
/*      */     
/*      */     private int occupation;
/*      */     
/*      */     private int gender;
/*      */     
/*      */     private int level;
/*      */     
/*      */     private int avatarid;
/*      */     
/*      */     private int avatar_frameid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  848 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  853 */       this.roleid = 0L;
/*  854 */       this.role_name = "";
/*      */     }
/*      */     
/*      */     Data(xbean.AllLottoAwardRoleInfo _o1_)
/*      */     {
/*  859 */       if ((_o1_ instanceof AllLottoAwardRoleInfo)) { assign((AllLottoAwardRoleInfo)_o1_);
/*  860 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  861 */       } else if ((_o1_ instanceof AllLottoAwardRoleInfo.Const)) assign(((AllLottoAwardRoleInfo.Const)_o1_).nThis()); else {
/*  862 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AllLottoAwardRoleInfo _o_) {
/*  867 */       this.roleid = _o_.roleid;
/*  868 */       this.role_name = _o_.role_name;
/*  869 */       this.occupation = _o_.occupation;
/*  870 */       this.gender = _o_.gender;
/*  871 */       this.level = _o_.level;
/*  872 */       this.avatarid = _o_.avatarid;
/*  873 */       this.avatar_frameid = _o_.avatar_frameid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  878 */       this.roleid = _o_.roleid;
/*  879 */       this.role_name = _o_.role_name;
/*  880 */       this.occupation = _o_.occupation;
/*  881 */       this.gender = _o_.gender;
/*  882 */       this.level = _o_.level;
/*  883 */       this.avatarid = _o_.avatarid;
/*  884 */       this.avatar_frameid = _o_.avatar_frameid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  890 */       _os_.marshal(this.roleid);
/*  891 */       _os_.marshal(this.role_name, "UTF-16LE");
/*  892 */       _os_.marshal(this.occupation);
/*  893 */       _os_.marshal(this.gender);
/*  894 */       _os_.marshal(this.level);
/*  895 */       _os_.marshal(this.avatarid);
/*  896 */       _os_.marshal(this.avatar_frameid);
/*  897 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  903 */       this.roleid = _os_.unmarshal_long();
/*  904 */       this.role_name = _os_.unmarshal_String("UTF-16LE");
/*  905 */       this.occupation = _os_.unmarshal_int();
/*  906 */       this.gender = _os_.unmarshal_int();
/*  907 */       this.level = _os_.unmarshal_int();
/*  908 */       this.avatarid = _os_.unmarshal_int();
/*  909 */       this.avatar_frameid = _os_.unmarshal_int();
/*  910 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  916 */       int _size_ = 0;
/*  917 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*      */       try
/*      */       {
/*  920 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  924 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  926 */       _size_ += CodedOutputStream.computeInt32Size(3, this.occupation);
/*  927 */       _size_ += CodedOutputStream.computeInt32Size(4, this.gender);
/*  928 */       _size_ += CodedOutputStream.computeInt32Size(5, this.level);
/*  929 */       _size_ += CodedOutputStream.computeInt32Size(6, this.avatarid);
/*  930 */       _size_ += CodedOutputStream.computeInt32Size(7, this.avatar_frameid);
/*  931 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  939 */         _output_.writeInt64(1, this.roleid);
/*  940 */         _output_.writeBytes(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*  941 */         _output_.writeInt32(3, this.occupation);
/*  942 */         _output_.writeInt32(4, this.gender);
/*  943 */         _output_.writeInt32(5, this.level);
/*  944 */         _output_.writeInt32(6, this.avatarid);
/*  945 */         _output_.writeInt32(7, this.avatar_frameid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  949 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  951 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  959 */         boolean done = false;
/*  960 */         while (!done)
/*      */         {
/*  962 */           int tag = _input_.readTag();
/*  963 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  967 */             done = true;
/*  968 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  972 */             this.roleid = _input_.readInt64();
/*  973 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/*  977 */             this.role_name = _input_.readBytes().toString("UTF-16LE");
/*  978 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  982 */             this.occupation = _input_.readInt32();
/*  983 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  987 */             this.gender = _input_.readInt32();
/*  988 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  992 */             this.level = _input_.readInt32();
/*  993 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  997 */             this.avatarid = _input_.readInt32();
/*  998 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1002 */             this.avatar_frameid = _input_.readInt32();
/* 1003 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1007 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1009 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1018 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1022 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1024 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllLottoAwardRoleInfo copy()
/*      */     {
/* 1030 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllLottoAwardRoleInfo toData()
/*      */     {
/* 1036 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AllLottoAwardRoleInfo toBean()
/*      */     {
/* 1041 */       return new AllLottoAwardRoleInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AllLottoAwardRoleInfo toDataIf()
/*      */     {
/* 1047 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AllLottoAwardRoleInfo toBeanIf()
/*      */     {
/* 1052 */       return new AllLottoAwardRoleInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1058 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1062 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1066 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1070 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1074 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1078 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1082 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1089 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRole_name()
/*      */     {
/* 1096 */       return this.role_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRole_nameOctets()
/*      */     {
/* 1103 */       return Octets.wrap(getRole_name(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupation()
/*      */     {
/* 1110 */       return this.occupation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGender()
/*      */     {
/* 1117 */       return this.gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 1124 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvatarid()
/*      */     {
/* 1131 */       return this.avatarid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvatar_frameid()
/*      */     {
/* 1138 */       return this.avatar_frameid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1145 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_name(String _v_)
/*      */     {
/* 1152 */       if (null == _v_)
/* 1153 */         throw new NullPointerException();
/* 1154 */       this.role_name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRole_nameOctets(Octets _v_)
/*      */     {
/* 1161 */       setRole_name(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupation(int _v_)
/*      */     {
/* 1168 */       this.occupation = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGender(int _v_)
/*      */     {
/* 1175 */       this.gender = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 1182 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvatarid(int _v_)
/*      */     {
/* 1189 */       this.avatarid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvatar_frameid(int _v_)
/*      */     {
/* 1196 */       this.avatar_frameid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1202 */       if (!(_o1_ instanceof Data)) return false;
/* 1203 */       Data _o_ = (Data)_o1_;
/* 1204 */       if (this.roleid != _o_.roleid) return false;
/* 1205 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 1206 */       if (this.occupation != _o_.occupation) return false;
/* 1207 */       if (this.gender != _o_.gender) return false;
/* 1208 */       if (this.level != _o_.level) return false;
/* 1209 */       if (this.avatarid != _o_.avatarid) return false;
/* 1210 */       if (this.avatar_frameid != _o_.avatar_frameid) return false;
/* 1211 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1217 */       int _h_ = 0;
/* 1218 */       _h_ = (int)(_h_ + this.roleid);
/* 1219 */       _h_ += this.role_name.hashCode();
/* 1220 */       _h_ += this.occupation;
/* 1221 */       _h_ += this.gender;
/* 1222 */       _h_ += this.level;
/* 1223 */       _h_ += this.avatarid;
/* 1224 */       _h_ += this.avatar_frameid;
/* 1225 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1231 */       StringBuilder _sb_ = new StringBuilder();
/* 1232 */       _sb_.append("(");
/* 1233 */       _sb_.append(this.roleid);
/* 1234 */       _sb_.append(",");
/* 1235 */       _sb_.append("'").append(this.role_name).append("'");
/* 1236 */       _sb_.append(",");
/* 1237 */       _sb_.append(this.occupation);
/* 1238 */       _sb_.append(",");
/* 1239 */       _sb_.append(this.gender);
/* 1240 */       _sb_.append(",");
/* 1241 */       _sb_.append(this.level);
/* 1242 */       _sb_.append(",");
/* 1243 */       _sb_.append(this.avatarid);
/* 1244 */       _sb_.append(",");
/* 1245 */       _sb_.append(this.avatar_frameid);
/* 1246 */       _sb_.append(")");
/* 1247 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AllLottoAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */